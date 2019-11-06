package com.domain.drapps.appstore.shared.repositories.protocols

import com.domain.drapps.appstore.shared.entities.AppObject

interface AppRepositoryProtocol {
    fun getAppList(callback: (List<AppObject>?) -> Unit)
}
