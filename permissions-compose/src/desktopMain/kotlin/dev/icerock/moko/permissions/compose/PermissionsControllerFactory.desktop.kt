package dev.icerock.moko.permissions.compose

import androidx.compose.runtime.Composable
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.PermissionsController

@Composable
actual fun rememberPermissionsControllerFactory(): PermissionsControllerFactory {
    return PermissionsControllerFactory { object: PermissionsController {
        override suspend fun providePermission(permission: Permission) {
            TODO("Not yet implemented")
        }

        override suspend fun isPermissionGranted(permission: Permission): Boolean {
            TODO("Not yet implemented")
        }

        override suspend fun getPermissionState(permission: Permission): PermissionState {
            TODO("Not yet implemented")
        }

        override fun openAppSettings() {
            TODO("Not yet implemented")
        }
    } }
}