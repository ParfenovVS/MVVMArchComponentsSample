package com.gitlab.parfenovvs.mvvmarchcomponentssample.util

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Vladimir Parfenov on 01.03.2018
 */

fun Disposable.addTo(compositeDisposable: CompositeDisposable) = compositeDisposable.add(this)

fun View.setVisibile(visible: Boolean) {
    this.visibility =
            if (visible) View.VISIBLE
            else View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}