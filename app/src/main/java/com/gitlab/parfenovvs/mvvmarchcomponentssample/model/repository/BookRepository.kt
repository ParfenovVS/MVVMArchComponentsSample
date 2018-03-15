package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.repository

import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.BookDAO
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.network.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class BookRepository @Inject constructor(
        private val api: ServerApi,
        private val dao: BookDAO
) {

    fun getBooks() = api
            .getBooks()
            .map { it.distinctBy { it.url } }
            .doOnSuccess(dao::update)
            .map { books ->
                Collections.sort(books, { b1, b2 -> b1.url.compareTo(b2.url) })
                return@map books
            }
            .toFlowable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}