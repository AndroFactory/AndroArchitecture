package andro.archi.plugin

import andro.archi.core.manager.DiskManager
import android.content.Context
import java.io.File

class DiskManagerPlugin constructor(private val context: Context): DiskManager {

    override fun createTempFile(fileName: String): File = File.createTempFile(fileName, null, context.getCacheDir())

}