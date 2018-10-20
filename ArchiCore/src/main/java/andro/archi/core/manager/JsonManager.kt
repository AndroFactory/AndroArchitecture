package andro.archi.core.manager

/**
 * Created by dev on 29/03/2018.
 */

interface JsonManager {

    fun <T> fromJson(json: String, typeOfT: Class<T>)
    fun toJson(src: Any): String?
}
