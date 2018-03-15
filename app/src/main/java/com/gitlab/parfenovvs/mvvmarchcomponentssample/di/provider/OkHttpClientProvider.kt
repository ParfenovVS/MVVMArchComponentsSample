package com.gitlab.parfenovvs.mvvmarchcomponentssample.di.provider

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class OkHttpClientProvider @Inject constructor() : Provider<OkHttpClient> {

    override fun get() = OkHttpClient
            .Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

}