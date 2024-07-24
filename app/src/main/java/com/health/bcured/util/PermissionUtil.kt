package com.health.bcured.util

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/** Constant for permission request.*/
private const val STORAGE_PERMISSION_CODE = 2

/**
 * Permission Utility object
 * provides permission status
 */
object PermissionUtil {

    /**
     * Function request for permission
     * and also returns the permission status
     * for Gallery intent result.
     */
    fun requestStoragePermission(activity: Activity): Boolean {
        val rationale = "We need storage permission to access files on your device"

        if (ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) ==
            PackageManager.PERMISSION_GRANTED) {
            return true
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                AlertDialog.Builder(activity)
                    .setTitle("Storage permission needed")
                    .setMessage(rationale)
                    .setPositiveButton("OK") { _, _ ->
                        ActivityCompat.requestPermissions(activity,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            STORAGE_PERMISSION_CODE)
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            } else {
                ActivityCompat.requestPermissions(activity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    STORAGE_PERMISSION_CODE)
            }
            return false
        }
    }
}
