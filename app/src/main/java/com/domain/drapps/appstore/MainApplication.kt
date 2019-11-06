package com.domain.drapps.appstore

import android.app.Application
import com.domain.drapps.appstore.shared.ServerAPI
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class MainApplication : Application() {
    private lateinit var serverAPI: ServerAPI

    override fun onCreate() {
        super.onCreate()
        createService()
    }

    private fun createService() : ServerAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        serverAPI = retrofit.create<ServerAPI>(ServerAPI::class.java)
        return serverAPI
    }

    fun getService(): ServerAPI {
        return if (::serverAPI.isInitialized) {
            serverAPI
        } else {
            createService()
        }
    }
}