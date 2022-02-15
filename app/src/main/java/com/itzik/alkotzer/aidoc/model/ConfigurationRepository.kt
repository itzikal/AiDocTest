package com.itzik.alkotzer.aidoc.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itzik.alkotzer.aidoc.R
import com.itzik.alkotzer.aidoc.helpers.ResourceHelper
import java.lang.Exception

class ConfigurationRepository(private val resourceHelper: ResourceHelper) {

    val configurations : List<Configuration>?

    init{
        configurations = readCountriesListFromLocal()
    }

    private fun readCountriesListFromLocal(): List<Configuration>? {
        try {

            val readAssetsFile = resourceHelper.readAssetsFile(R.raw.configuration)
            val gson = Gson()
            val itemType = object : TypeToken<List<Configuration>>() {}.type
            return gson.fromJson<List<Configuration>>(readAssetsFile, itemType)

        } catch (ex: Exception) {

        }
        return null
    }

}