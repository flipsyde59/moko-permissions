package dev.icerock.moko.permissions.test

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionsController

actual abstract class PermissionsControllerMock actual constructor() : PermissionsController {
    actual abstract override suspend fun providePermission(permission: Permission)
    actual abstract override suspend fun isPermissionGranted(permission: Permission): Boolean

    actual companion object

}