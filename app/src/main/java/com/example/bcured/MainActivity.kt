package com.example.bcured

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.bcured.Presentation.Navigation.Navigation
import com.example.bcured.ViewModel.ImageSelectionViewModel
import android.Manifest
import android.content.pm.PackageManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val imageSelectionViewModel: ImageSelectionViewModel by viewModels()

    private var imageUri by mutableStateOf<Uri?>(null)

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                takePicture()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private val galleryResult =
        registerForActivityResult(ActivityResultContracts
            .StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val selectedImageUri: Uri? = result.data?.data
                selectedImageUri?.let {
                    imageSelectionViewModel.setSelectedImageUri(it)
                }
            }
        }

    private val cameraResult =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                imageUri?.let { uri ->
                    saveImageUriToGallery(uri)
                    imageSelectionViewModel.setSelectedImageUri(uri)
                    setResult(RESULT_OK, Intent().apply {
                        data = uri
                    })
                } ?: run {
                    setResult(RESULT_CANCELED)
                }
            } else {
                Toast.makeText(this, "Failed to take picture", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            fun onCameraButtonClicked() {
                checkCameraPermission()
            }
            fun onImageButtonClicked() {
                openGalleryForImage()
            }

            Navigation(
                navController,
                imageSelectionViewModel,
                { onCameraButtonClicked() },
                { onImageButtonClicked() },
                activity = this@MainActivity
            )
        }
    }

    @SuppressLint("IntentReset")
    private fun openGalleryForImage() {
        val imageIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        imageIntent.type = "image/*"
        galleryResult.launch(imageIntent)
    }

    private fun takePicture() {
        imageUri?.let { cameraResult.launch(it) }
    }

    private fun saveImageUriToGallery(imageUri: Uri) {
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "Image_${System.currentTimeMillis()}.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "DCIM/Bcured")
            }
        }
        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            ?.let { outputStream ->
                contentResolver.openOutputStream(outputStream).use { output ->
                    contentResolver.openInputStream(imageUri)?.use { input ->
                        if (output != null) {
                            input.copyTo(output)
                        }
                    }
                }
            }
    }

   private fun checkCameraPermission() {
       when {
           ContextCompat.checkSelfPermission(
               this,
               Manifest.permission.CAMERA
           ) == PackageManager.PERMISSION_GRANTED -> {
               startCamera()
           }
           else -> {
               requestPermissionLauncher.launch(Manifest.permission.CAMERA)
           }
       }
   }
    private fun startCamera() {
        val photoUri = createImageUri()
        photoUri?.let {
            imageUri = it
            cameraResult.launch(it)
        }
    }
    private fun createImageUri() : Uri? {
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "Image_${System.currentTimeMillis()}.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "DCIM/Bcured")
            }
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
    }
}


