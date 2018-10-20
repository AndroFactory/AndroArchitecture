package andro.archi.extension

import andro.archi.core.manager.PermissionManager
import andro.archi.core.model.GrantResult
import andro.archi.SuperActivity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.SparseArray


/**
 * Created by pguifo on 23/03/2018.
 */

class RequestPermissionExtension internal constructor(private val activity: SuperActivity) : PermissionManager {

    private val permissionsPublisher = SparseArray<(Map<String, GrantResult>) -> Unit>()

    override fun ckeckGrantPermission(permission: String) = GrantResult(permission,
            ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED,
            ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    )

    override fun requestPermissions(requestCode : Int, permissions: Array<out String>, publisher: (Map<String, GrantResult>) -> Unit){
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
        permissionsPublisher.put(requestCode, publisher)
    }

    override fun requestPermission(requestCode : Int, permission: String, publisher: (GrantResult) -> Unit){
        requestPermissions(requestCode, arrayOf(permission)) { mapGrantResult ->
            publisher(mapGrantResult[permission]!!)
        }
    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        permissionsPublisher[requestCode]?.let { publisher ->
            val grantResultMap = hashMapOf<String, GrantResult>()
            permissions.forEachIndexed { index, permission ->
                grantResultMap[permission] = GrantResult(
                        permission,
                        grantResults[index] == PackageManager.PERMISSION_GRANTED,
                        ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
                )
            }
            publisher(grantResultMap)
        }
    }
}
