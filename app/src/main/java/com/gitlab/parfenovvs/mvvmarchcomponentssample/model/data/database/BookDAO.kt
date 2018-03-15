package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.gitlab.parfenovvs.mvvmarchcomponentssample.entity.Book
import io.reactivex.Flowable

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
@Dao
interface BookDAO {

    @Query("SELECT * FROM book")
    fun getAll(): Flowable<List<Book>>

    @Query("SELECT * FROM book WHERE url LIKE :url")
    fun get(url: String): Flowable<Book>

    @Update
    fun update(books: List<Book>)

}