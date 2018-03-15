package com.gitlab.parfenovvs.mvvmarchcomponentssample.di.provider

import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.server.DateDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.threeten.bp.LocalDateTime
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class GsonProvider @Inject constructor() : Provider<Gson> {

    override fun get(): Gson =
            GsonBuilder()
                    .registerTypeAdapter(LocalDateTime::class.java, DateDeserializer())
                    .create()

}