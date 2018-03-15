package com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
sealed class ViewState {
    class Success<out T>(val data: T): ViewState()
    class Loading: ViewState()
    class Error(val error: Throwable): ViewState()
}