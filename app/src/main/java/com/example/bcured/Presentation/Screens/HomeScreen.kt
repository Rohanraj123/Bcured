package com.example.bcured.Presentation.Screens

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bcured.Presentation.Components.AskForPicture
import com.example.bcured.Presentation.Components.BackButton
import com.example.bcured.Presentation.Components.CustomFloatingButton
import com.example.bcured.Presentation.Components.ShowImage
import com.example.bcured.Presentation.Components.SubmitButton
import com.example.bcured.Presentation.Components.WelcomeText
import com.example.bcured.ViewModel.ImageSelectionViewModel
import com.example.bcured.util.PermissionUtil
import com.example.bcured.util.calculateCurrentWidth
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeScreen(
    imageSelectionViewModel: ImageSelectionViewModel,
    onCameraButtonClicked: () -> Unit,
    onImageButtonClicked: () -> Unit,
    activity: Activity
) {
    val context = LocalContext.current
    val paddingStart = calculateCurrentWidth(context).dp

    val selectedImageUri = imageSelectionViewModel.selectedImageUri.collectAsState()

    var imageSelectionStatus by remember {
        mutableStateOf(false)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BackButton {/* OnClick */ }
            Spacer(modifier = Modifier.width(30.dp))
            WelcomeText()
        }
        Row(
            modifier = Modifier.padding(horizontal = paddingStart / 14)
        ) {
            if (!imageSelectionStatus) {
                AskForPicture(paddingStart)
            } else {
                ShowImage(selectedImageUri.value)
            }
        }
        SubmitButton(
            onClick = {},
            modifier = Modifier
                .padding(horizontal = paddingStart / 11)
                .height(50.dp)
                .width(300.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomFloatingButton(
                text = "C",
                onClick = {
                    onCameraButtonClicked()
                    imageSelectionStatus = true
                          },
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(30.dp))
            CustomFloatingButton(
                text = "G",
                onClick = {
                    val isPermissionGranted = PermissionUtil.requestStoragePermission(activity)
                    if (isPermissionGranted) {
                        onImageButtonClicked()
                        imageSelectionStatus = true
                    }
                          },
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        imageSelectionViewModel = ImageSelectionViewModel(),
        onCameraButtonClicked = { /*TODO*/ },
        onImageButtonClicked = { /*TODO*/ },
        activity = Activity()
    )
}
