package com.domain.drapps.appstore.features.applist.presentation

import com.domain.drapps.appstore.shared.repositories.server.AppRepositoryServer

class HomeStoreScene {
    companion object {
        fun createScene(sceneView: HomeStoreContract.View) {
            sceneView.presenter = HomeStorePresenter()
                .apply {
                    view = sceneView
                    appRepository = AppRepositoryServer()
                }
        }
    }
}
