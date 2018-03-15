package com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.gitlab.parfenovvs.mvvmarchcomponentssample.App
import com.gitlab.parfenovvs.mvvmarchcomponentssample.entity.Book
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.interactor.BookInteractor
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.repository.BookRepository
import com.gitlab.parfenovvs.mvvmarchcomponentssample.util.addTo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class BooksViewModel constructor(
        application: App,
        private val interactor: BookInteractor
) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    val data = MutableLiveData<ViewState>()

    fun loadBooks() {
        interactor.getBooks()
                .doOnSubscribe { data.value = ViewState.Loading() }
                .subscribe(
                        { books -> data.value = ViewState.Success(books) },
                        { error -> data.value = ViewState.Error(error) }
                )
                .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}