package com.gitlab.parfenovvs.mvvmarchcomponentssample.di.provider

import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.AppDatabase
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.BookDAO
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class BookDAOProvider @Inject constructor(private val database: AppDatabase): Provider<BookDAO> {

    override fun get() = database.bookDao()

}