package com.gitlab.parfenovvs.mvvmarchcomponentssample.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.gitlab.parfenovvs.mvvmarchcomponentssample.R
import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.DI
import com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base.BaseActivity
import com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.books.BooksFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Replace
import toothpick.Toothpick

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class MainActivity : BaseActivity() {

    override val layoutRes = R.layout.activity_main

    override val navigator = object : SupportAppNavigator(this, R.id.container) {

        override fun createActivityIntent(context: Context, screenKey: String, data: Any?): Intent? {
            return null
        }

        override fun createFragment(screenKey: String, data: Any?): Fragment =
                when (screenKey) {
                    Screens.BOOKS_SCREEN -> BooksFragment()
                    else -> throw RuntimeException("Screen $screenKey not found")
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))

        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            navigator.applyCommands(arrayOf(Replace(Screens.BOOKS_SCREEN, null)))
        }
    }

}
