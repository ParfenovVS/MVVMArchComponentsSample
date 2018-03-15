package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.network

import com.gitlab.parfenovvs.mvvmarchcomponentssample.entity.Book
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
interface ServerApi {

    @GET("api/books")
    fun getBooks(): Single<List<Book>>

}