package com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.books

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.gitlab.parfenovvs.mvvmarchcomponentssample.R
import com.gitlab.parfenovvs.mvvmarchcomponentssample.entity.Book
import com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base.ItemView
import com.gitlab.parfenovvs.mvvmarchcomponentssample.util.inflate
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import kotlinx.android.synthetic.main.item_book.view.*

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class BookDelegate: AdapterDelegate<List<ItemView>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_book))

    override fun isForViewType(items: List<ItemView>, position: Int) = items[position] is Book

    override fun onBindViewHolder(items: List<ItemView>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        (holder as ViewHolder).bind(items[position] as Book)
    }

    private class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Book) {
            itemView.titleTextView.text = item.name
        }
    }
}