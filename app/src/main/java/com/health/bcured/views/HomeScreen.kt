package com.health.bcured.views

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.health.bcured.ui.theme.BlueColor
import com.health.bcured.util.PermissionUtil
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.viewmodel.ImageSelectionViewModel
import com.health.bcured.views.components.BlueButton
import com.health.bcured.views.components.CircularButton
import com.health.bcured.views.components.ExtractedText
import com.health.bcured.views.components.ImageViewer

@Composable
fun HomeScreen(
    authViewModel: AuthViewModel,
    navHostController: NavHostController,
    imageSelectionViewModel: ImageSelectionViewModel,
    onGalleryButtonClicked: () -> Unit,
    onCameraButtonClicked: () -> Unit,
) {

    val imageResult by imageSelectionViewModel.imageResult.collectAsState()
    val activity = LocalContext.current as ComponentActivity
    val isPermissionGranted = PermissionUtil.requestStoragePermission(activity)

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Bcured Support", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 50.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Good Morning", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            ImageViewer(imageResult)
            Spacer(modifier = Modifier.height(10.dp))
            BlueButton(title = "Submit Image", onClick = { TODO() })
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Confirm the extracted Text : ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            ExtractedText(content = "Hey THere everyone I am new to this programming world !")
            Spacer(modifier = Modifier.height(10.dp))
            BlueButton(title = "Submit text", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(10.dp))
            BlueButton(title = "Download pdf", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(10.dp))
            BlueButton(title = "Get it via mail", onClick = { /*TODO*/ })
            Row (modifier = Modifier.fillMaxWidth().padding(bottom = 50.dp).wrapContentHeight(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CircularButton(onClick = { onCameraButtonClicked() }, title = "C")
                CircularButton(onClick = { if (isPermissionGranted) onGalleryButtonClicked() }, title = "G")
            }
        }
    }
}




