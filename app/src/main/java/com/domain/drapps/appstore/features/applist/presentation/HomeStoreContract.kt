package com.domain.drapps.appstore.features.applist.presentation

import com.domain.drapps.appstore.shared.entities.AppObject
import com.domain.drapps.appstore.shared.repositories.protocols.AppRepositoryProtocol
import com.domain.drapps.appstore.shared.baseui.BaseViewContract

interface HomeStoreContract {
    interface View: BaseViewContract {
        var presenter: Presenter

        fun updateAppList(list: List<AppObject>)
        fun onError()
    }

    interface Presenter {
        var view: View
        var appRepository: AppRepositoryProtocol
        fun requestAppList()
    }
}
