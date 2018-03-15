package com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
abstract class BaseFragment: Fragment() {
    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }
}