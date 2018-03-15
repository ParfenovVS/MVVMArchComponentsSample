package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.interactor

import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.repository.BookRepository
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 15.03.2018
 */
class BookInteractor @Inject constructor(private val repository: BookRepository) {

    fun getBooks() = repository.getBooks()

}