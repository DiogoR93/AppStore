package com.domain.drapps.appstore.features.applist.presentation

import com.domain.drapps.appstore.shared.repositories.protocols.AppRepositoryProtocol

class HomeStorePresenter : HomeStoreContract.Presenter {

    override lateinit var view: HomeStoreContract.View
    override lateinit var appRepository: AppRepositoryProtocol

    override fun requestAppList() {
        view.startLoading()
        appRepository.getAppList { response ->
            if (response != null) {
                view.updateAppList(response)
            } else {
                view.onError()
            }
            view.stopLoading()
        }
    }

}
