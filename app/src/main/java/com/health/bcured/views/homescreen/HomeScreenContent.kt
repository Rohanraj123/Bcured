package com.health.bcured.views.homescreen

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.bcured.ui.theme.BlueColor
import com.health.bcured.util.ResponseUiState
import com.health.bcured.viewmodel.TextAnalysisViewModel
import com.health.bcured.views.components.BlueButton
import com.health.bcured.views.components.CardLayout
import com.health.bcured.views.components.ImageViewer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    imageUri: Uri?,
    onGalleryButtonClicked: () -> Unit,
    textAnalysisViewModel: TextAnalysisViewModel,
    responseUiState: ResponseUiState
) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var reportName by remember { mutableStateOf("") }

    val imageTextContent by textAnalysisViewModel.imageTextContent.collectAsState()
    var isLoadingText by remember { mutableStateOf(false) }
    val promptResponse by textAnalysisViewModel.promptResponse.collectAsState()

    LaunchedEffect(promptResponse) {
        if (promptResponse.isNotEmpty()) {
            isLoadingText = false
        }
    }

    fun onAnalyzeButtonClick() {
        if (imageUri != null) {
            isLoadingText = true
            textAnalysisViewModel.extractImageText(imageUri)
            showBottomSheet = false
        }
    }
    LaunchedEffect(imageTextContent) {
        val text = imageTextContent ?: return@LaunchedEffect
        if (text.isNotEmpty()) {
            textAnalysisViewModel.makePrompt(reportName)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BlueColor,
                    titleContentColor = Color.White,
                ),
                title = {
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                tint = Color.White
                            )
                            Column {
                                Text(text = "Rohan Jha", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text(text = "rajrohan88293@gmail.com", fontSize = 10.sp)
                            }
                        }
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp),
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showBottomSheet = true },
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                containerColor = BlueColor
            ) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isLoadingText) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(vertical = 200.dp, horizontal = 100.dp)
                        .padding(16.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 60.dp),
                    contentPadding = PaddingValues(bottom = 70.dp)
                ) {
                    items(responseUiState.responseList) { item ->
                        Log.d("HomeScreen", "content : ${item.content}")
                        CardLayout(content = item.content, reportName = item.reportName)
                    }
                }
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState
                ) {
                    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                        TextButton(
                            onClick = { showBottomSheet = false },
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Row (
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null)
                                Text(text = "Back", fontWeight = FontWeight.Bold)
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Enter Report name", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(10.dp))
                        TextField(
                            value = reportName,
                            onValueChange = { reportName = it },
                            placeholder = { Text(text = "Enter report name... ")},
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Select Report image", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ImageViewer(uri = imageUri)
                            Row {
                                IconButton(
                                    onClick = { onGalleryButtonClicked() }
                                ) {
                                    Icon(Icons.Default.AddCircle, contentDescription = null, modifier = Modifier.size(50.dp))
                                }
                                IconButton(
                                    onClick = {  }
                                ) {
                                    Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(50.dp))
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        BlueButton(
                            title = "Analyze Report",
                            onClick = {
                                onAnalyzeButtonClick()
                                }
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }
    }
}

