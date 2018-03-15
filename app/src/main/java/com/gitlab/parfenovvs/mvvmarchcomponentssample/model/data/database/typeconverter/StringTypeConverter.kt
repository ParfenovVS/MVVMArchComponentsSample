package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.typeconverter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



/**
 * @author Vladimir Parfenov on 02.03.2018
 */
class StringTypeConverter {

    companion object {

        @JvmStatic
        @TypeConverter
        fun restore(listOfString: String): List<String> {
            return Gson().fromJson(listOfString, object : TypeToken<List<String>>() {
            }.type)
        }

        @JvmStatic
        @TypeConverter
        fun save(listOfString: List<String>): String {
            return Gson().toJson(listOfString)
        }
    }

}