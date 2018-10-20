package andro.archi.core.manager

import java.io.File

/**
 * Created by dev on 29/03/2018.
 */

interface DiskManager {

    fun createTempFile(fileName: String): File
}
