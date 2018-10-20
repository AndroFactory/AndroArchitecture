package andro.archi.extension

import andro.archi.SuperActivity
import android.content.Intent
import android.util.SparseArray

class StartActivityForResultExtension constructor(private val activity: SuperActivity) : ((Int, Intent, ((Int, Int, Intent?) -> Unit)) -> Unit) {

    private val activityResultPublisher = SparseArray<(requestCode: Int, resultCode: Int, data: Intent?) -> Unit>()

    override fun invoke(requestCode: Int, intent: Intent, publisher: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit) {
        doStartActivityForResult(requestCode, intent, publisher)
    }

    fun doStartActivityForResult(requestCode: Int, intent: Intent, publisher: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit) {
        activityResultPublisher.put(requestCode, publisher)
        activity.startActivityForResult(intent, requestCode)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        activityResultPublisher[requestCode]?.let { publish ->
            publish(requestCode, resultCode, data)
        }
    }
}