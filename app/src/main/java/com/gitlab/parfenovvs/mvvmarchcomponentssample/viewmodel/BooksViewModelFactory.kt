package com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.gitlab.parfenovvs.mvvmarchcomponentssample.App
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.interactor.BookInteractor
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class BooksViewModelFactory @Inject constructor(
        private val application: App,
        private val interactor: BookInteractor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            return BooksViewModel(application, interactor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class");
    }

}