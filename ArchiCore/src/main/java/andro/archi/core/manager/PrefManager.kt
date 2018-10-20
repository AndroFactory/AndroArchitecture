package andro.archi.core.manager


/**
 * Created by dev on 29/03/2018.
 */

interface PrefManager {

    fun saveData(key: String, value : String)

    fun getData(key: String) : String?
}
