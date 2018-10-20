package andro.archi.core.manager

import andro.archi.core.model.GrantResult

/**
 * Created by dev on 29/03/2018.
 */

interface PermissionManager {

    fun ckeckGrantPermission(permission: String): GrantResult

    fun requestPermission(requestCode: Int, permission: String, publisher: (GrantResult) -> Unit)

    fun requestPermissions(requestCode: Int, permissions: Array<out String>, publisher: (Map<String, GrantResult>) -> Unit)
}
