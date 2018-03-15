package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.database.typeconverter

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * @author Vladimir Parfenov on 02.03.2018
 */
class DateTypeConverter {

    companion object {

        @JvmStatic
        @TypeConverter
        fun restore(dateStr: String): LocalDateTime {
            return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        }

        @JvmStatic
        @TypeConverter
        fun save(date: LocalDateTime): String {
            return date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        }
    }

}