package com.health.bcured.views.homescreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.bcured.viewmodel.AuthViewModel
import com.health.bcured.viewmodel.ImageSelectionViewModel
import com.health.bcured.viewmodel.TextAnalysisViewModel

@Composable
fun HomeScreen(
    authViewModel: AuthViewModel,
    imageSelectionViewModel: ImageSelectionViewModel,
    textAnalysisViewModel: TextAnalysisViewModel,
    onGalleryButtonClicked: () -> Unit
) {

    val imageResult by imageSelectionViewModel.imageResult.collectAsState()
    val responseUiState by textAnalysisViewModel.responsesListUiState.collectAsState()

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet (modifier = Modifier.padding(end = 50.dp)){
            Text(
                text = "Settings ",
                modifier = Modifier.padding(16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Divider()
            NavigationDrawerItem(
                label = { Text(text = "Any Issue? Contact Us") },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(Icons.Default.Email, contentDescription = null, tint = Color.Black) },
                modifier = Modifier.padding(10.dp)
            )
            NavigationDrawerItem(
                label = { Text(text = "Rate Us") },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(Icons.Default.Star, contentDescription = null, tint = Color.Black) },
                modifier = Modifier.padding(10.dp)
            )
            NavigationDrawerItem(
                label = { Text(text = "Share App") },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(Icons.Default.Share, contentDescription = null, tint = Color.Black) },
                modifier = Modifier.padding(10.dp)
            )
            NavigationDrawerItem(
                label = { Text(text = "Privacy policy") },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(Icons.Default.Info, contentDescription = null, tint = Color.Black) },
                modifier = Modifier.padding(10.dp)
            )
            NavigationDrawerItem(
                label = { Text(text = "Suggestions") },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(Icons.Default.Warning, contentDescription = null, tint = Color.Black) },
                modifier = Modifier.padding(10.dp)
            )
            NavigationDrawerItem(
                label = { Text(text = "Sign Out") },
                selected = false,
                onClick = { authViewModel.logOut() },
                icon = { Icon(Icons.Default.ExitToApp, contentDescription = null, tint = Color.Black) },
                modifier = Modifier.padding(10.dp)
            )
        }
    },
        gesturesEnabled = true
    ) {
        HomeScreenContent(
            imageResult,
            onGalleryButtonClicked,
            textAnalysisViewModel,
            responseUiState
        )
    }

}