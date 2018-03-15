package com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
abstract class BaseActivity: AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected abstract val layoutRes: Int
    protected abstract val navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}