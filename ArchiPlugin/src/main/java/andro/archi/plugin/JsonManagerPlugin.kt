package andro.archi.plugin

import andro.archi.core.manager.JsonManager
import com.google.gson.Gson

class JsonManagerPlugin : JsonManager {

    private val gson = Gson()

    override fun toJson(src: Any) = gson.toJson(src)

    override fun <T>fromJson(json: String, typeOfT: Class<T>) {
        gson.fromJson(json, typeOfT)
    }

}