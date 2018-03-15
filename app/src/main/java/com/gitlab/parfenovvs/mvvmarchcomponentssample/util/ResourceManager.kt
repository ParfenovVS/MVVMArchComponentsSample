package com.gitlab.parfenovvs.mvvmarchcomponentssample.util

import android.content.Context
import javax.inject.Inject

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class ResourceManager @Inject constructor(private val context: Context) {

    fun getString(id: Int) = context.getString(id)

}