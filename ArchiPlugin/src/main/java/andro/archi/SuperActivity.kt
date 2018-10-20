package andro.archi

import andro.archi.extension.RequestPermissionExtension
import andro.archi.extension.StartActivityForResultExtension
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by pguifo on 28/01/2018.
 */
open class SuperActivity : AppCompatActivity() {

    val startActivityForResultExtension = StartActivityForResultExtension(activity = this)

    val requestPermissionExtension = RequestPermissionExtension(activity = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SuperInjector).injectActivity(this)
    }

    fun doStartActivityForResult(requestCode: Int, intent: Intent, publisher: (Int, Int, Intent?) -> Unit) {
        this.startActivityForResultExtension.doStartActivityForResult(requestCode, intent, publisher)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        startActivityForResultExtension.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        requestPermissionExtension.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}