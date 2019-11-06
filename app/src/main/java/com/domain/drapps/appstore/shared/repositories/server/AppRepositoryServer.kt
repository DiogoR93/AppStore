package com.domain.drapps.appstore.shared.repositories.server

import com.domain.drapps.appstore.shared.repositories.server.responseobject.AppListResponse
import com.domain.drapps.appstore.shared.entities.AppObject
import com.domain.drapps.appstore.shared.repositories.protocols.AppRepositoryProtocol
import com.domain.drapps.appstore.MainApplication
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AppRepositoryServer : AppRepositoryProtocol {
    override fun getAppList(callback: (List<AppObject>?) -> Unit) {
        val observable = MainApplication().getService().getAppList()
        observable.subscribeOn(Schedulers.io())
            .subscribe(
                object : Observer<AppListResponse> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(t: AppListResponse) {
                        val appList = ArrayList<AppObject>()
                        t.responses.listApps.datasets.all.data.list.forEach {
                            appList.add(AppObject().apply {
                                name = it.name
                                icon = it.icon
                                graphic = it.graphic ?: ""
                                rating = it.rating
                            })
                        }
                        callback.invoke(appList)
                    }

                    override fun onError(e: Throwable) {
                        callback.invoke(null)
                        e.printStackTrace()
                    }
                })
    }
}