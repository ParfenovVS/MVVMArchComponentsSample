package com.gitlab.parfenovvs.mvvmarchcomponentssample.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.gitlab.parfenovvs.mvvmarchcomponentssample.ui.base.ItemView
import org.threeten.bp.LocalDateTime
import java.util.*

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
@Entity(tableName = "book")
data class Book(
        @PrimaryKey val url: String,
        val name: String,
        val isbn: String,
        val authors: List<String>,
        val numberOfPages: Int,
        val publisher: String,
        val country: String,
        val mediaType: String,
        val released: LocalDateTime,
        val characters: List<String>,
        val povCharacters: List<String>
): ItemView