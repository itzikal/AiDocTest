package com.itzik.alkotzer.aidoc.helpers

import android.content.Context
import android.util.Log
import com.itzik.alkotzer.aidoc.R

private const val TAG = "resourceHelper"
class ResourceHelper(private val appContext: Context) {

    fun readAssetsFile(assetId: Int): String {
        return try {
            appContext.resources.openRawResource(assetId).bufferedReader()
                .use { it.readText() }
        } catch (e: Exception) {
            Log.e(TAG, "readAssetsFile: failed to open/ read file ", e)
            ""
        }
    }
}