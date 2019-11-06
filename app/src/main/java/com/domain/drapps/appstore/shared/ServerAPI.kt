package com.domain.drapps.appstore.shared

import com.domain.drapps.appstore.shared.repositories.server.responseobject.AppListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ServerAPI {

    @GET("https://ws2.aptoide.com/api/6/bulkRequest/api_list/listApps")
    fun getAppList(): Observable<AppListResponse>
}