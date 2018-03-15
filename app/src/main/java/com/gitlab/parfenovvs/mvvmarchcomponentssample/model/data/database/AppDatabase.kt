package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.gitlab.parfenovvs.mvvmarchcomponentssample.entity.Book
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.typeconverter.DateTypeConverter
import com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.typeconverter.StringTypeConverter

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
@Database(entities = [(Book::class)], version = 1)
@TypeConverters(StringTypeConverter::class, DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDAO
}