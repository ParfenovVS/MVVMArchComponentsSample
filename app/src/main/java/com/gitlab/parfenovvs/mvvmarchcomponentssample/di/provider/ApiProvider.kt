package com.gitlab.parfenovvs.mvvmarchcomponentssample.di.provider

import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.qualifier.ApiEndpoint
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.network.ServerApi
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class ApiProvider @Inject constructor(
        private val okHttpClient: OkHttpClient,
        private val gson: Gson,
        @ApiEndpoint private val apiEndpoint: String
): Provider<ServerApi> {

    override fun get() =
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(apiEndpoint)
                    .build()
                    .create(ServerApi::class.java)

}