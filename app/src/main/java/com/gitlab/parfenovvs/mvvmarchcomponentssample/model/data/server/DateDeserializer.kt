package com.gitlab.parfenovvs.mvvmarchcomponentssample.model.data.server

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.lang.reflect.Type

/**
 * @author Vladimir Parfenov on 01.03.2018
 */
class DateDeserializer : JsonDeserializer<LocalDateTime> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?) =
            LocalDateTime.parse(json.asJsonPrimitive.asString, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

}