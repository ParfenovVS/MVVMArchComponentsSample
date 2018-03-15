package com.gitlab.parfenovvs.mvvmarchcomponentssample.di.module

import android.content.Context
import com.gitlab.parfenovvs.mvvmarchcomponentssample.App
import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.provider.*
import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.qualifier.ApiEndpoint
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.AppDatabase
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.BookDAO
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.interactor.BookInteractor
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.network.ServerApi
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.repository.BookRepository
import com.gitlab.parfenovvs.mvvmarchcomponentssample.util.ResourceManager
import com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel.BooksViewModelFactory
import com.google.gson.Gson
import okhttp3.OkHttpClient
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class AppModule(application: App) : Module() {
    init {
        bind(Context::class.java).toInstance(application)
        bind(App::class.java).toInstance(application)
        bind(ResourceManager::class.java).singletonInScope()

        //Cicerone
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)

        //Network
        bind(String::class.java).withName(ApiEndpoint::class.java).toInstance("https://anapioficeandfire.com")
        bind(Gson::class.java).toProvider(GsonProvider::class.java).providesSingletonInScope()
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java).providesSingletonInScope()
        bind(ServerApi::class.java).toProvider(ApiProvider::class.java).providesSingletonInScope()

        //Database
        bind(AppDatabase::class.java).toProvider(DatabaseProvider::class.java)
        bind(BookDAO::class.java).toProvider(BookDAOProvider::class.java).providesSingletonInScope()

        //Books
        bind(BookRepository::class.java)
        bind(BookInteractor::class.java)
        bind(BooksViewModelFactory::class.java)
    }
}