package com.gitlab.parfenovvs.mvvmarchcomponentssample

import android.app.Application
import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.DI
import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.module.AppModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initAppScope()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initAppScope() {
        Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
        FactoryRegistryLocator.setRootRegistry(com.gitlab.parfenovvs.mvvmarchcomponentssample.FactoryRegistry());
        MemberInjectorRegistryLocator.setRootRegistry(com.gitlab.parfenovvs.mvvmarchcomponentssample.MemberInjectorRegistry());

        Toothpick
                .openScope(DI.APP_SCOPE)
                .installModules(AppModule(this))
    }
}