package com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.books

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gitlab.parfenovvs.mvvmarchcomponentssample.R
import com.gitlab.parfenovvs.mvvmarchcomponentssample.di.DI
import com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base.BaseFragment
import com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base.ItemView
import com.gitlab.parfenovvs.mvvmarchcomponentssample.util.setVisibile
import com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel.BooksViewModel
import com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel.BooksViewModelFactory
import com.gitlab.parfenovvs.mvvmarchcomponentssample.viewmodel.ViewState
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import kotlinx.android.synthetic.main.fragment_books.*
import timber.log.Timber
import toothpick.Toothpick
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class BooksFragment : BaseFragment() {
    override val layoutRes = R.layout.fragment_books

    @Inject
    lateinit var viewModelFactory: BooksViewModelFactory

    private lateinit var viewModel: BooksViewModel

    private val adapter = BooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(BooksViewModel::class.java)
        viewModel.data
                .observe(this, Observer<ViewState> { processViewState(it) })
        if (savedInstanceState == null) {
            viewModel.loadBooks()
        }
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun processViewState(viewState: ViewState?) {
        viewState?.let {
            when (it) {
                is ViewState.Loading -> showLoading()
                is ViewState.Success<*> -> (it.data as? List<ItemView>)?.let { showData(it) }
                is ViewState.Error -> showError(it.error)
            }
        }
    }

    private fun showLoading() {
        loadingView.setVisibile(true)
        emptyView.setVisibile(false)
        recyclerView.setVisibile(false)
    }

    private fun showData(items: List<ItemView>) {
        adapter.items = items
        loadingView.setVisibile(false)
        emptyView.setVisibile(false)
        recyclerView.setVisibile(true)
    }

    private fun showError(error: Throwable) {
        Timber.e(error)
        loadingView.setVisibile(false)
        emptyView.setVisibile(true)
        recyclerView.setVisibile(false)
    }

    private inner class BooksAdapter : ListDelegationAdapter<List<ItemView>>() {
        init {
            delegatesManager.addDelegate(BookDelegate())
        }
    }
}