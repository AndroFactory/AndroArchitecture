package andro.archi.plugin

import andro.archi.core.manager.PrefManager
import android.content.Context

class PrefManagerPlugin constructor(context: Context): PrefManager {

    private val sharedPref = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    override fun saveData(key: String, value: String) = with (sharedPref.edit()) {
        putString(key, value)
        apply()
    }

    override fun getData(key: String): String? = sharedPref.getString(key, null)




}

