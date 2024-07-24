package com.health.bcured

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.health.bcured.ui.theme.BcuredTheme
import com.health.bcured.util.PermissionUtil
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.viewmodel.ImageSelectionViewModel
import com.health.bcured.viewmodel.TextAnalysisViewModel
import com.health.bcured.views.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /** To set the value of uri using setter.*/
    private val imageSelectionViewModel: ImageSelectionViewModel by viewModels()

    /** Uses registerForActivityResult API to register the URI.*/
    private val galleryResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val selectedImageUri: Uri? = result.data?.data
                selectedImageUri?.let { imageSelectionViewModel.onGalleryResult(it) }
            }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BcuredTheme {
                val navController = rememberNavController()
                val authViewModel = hiltViewModel<AuthViewModel>()
                val textAnalysisViewModel = hiltViewModel<TextAnalysisViewModel>()

                val imageSelectionViewModel =
                    ViewModelProvider(this)[ImageSelectionViewModel::class.java]

                Navigation(
                    navController,
                    authViewModel,
                    imageSelectionViewModel,
                    textAnalysisViewModel,
                    onGalleryButtonClicked = { onGalleryButtonClicked() }
                )
            }
        }
    }

    /** Method gets invoked when Gallery button clicked.*/
    private fun onGalleryButtonClicked() {
        val isPermissionGranted = PermissionUtil.requestStoragePermission(activity = this)
        if (isPermissionGranted) openGalleryForImage()
        else Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
    }

    /**
     * Supportive method to onGalleryButtonClicked()
     * Opens the gallery and give the result back
     * by initialising the galleryResult lambda
     */
    @SuppressLint("IntentReset")
    private fun openGalleryForImage() {
        val imageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        imageIntent.type = "image/*"
        galleryResult.launch(imageIntent)
    }
}
