package com.gitlab.parfenovvs.mvvmarchcomponentssample.di.provider

import android.arch.persistence.room.Room
import android.content.Context
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.AppDatabase
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class DatabaseProvider @Inject constructor(private val context: Context): Provider<AppDatabase> {

    override fun get() = Room
            .databaseBuilder(context, AppDatabase::class.java, "database")
            .build()

}