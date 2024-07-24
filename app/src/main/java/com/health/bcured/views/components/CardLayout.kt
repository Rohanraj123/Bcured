package com.health.bcured.views.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.bcured.ui.theme.BlueColor
import com.health.bcured.util.Translator
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLayout(
    content: String,
    reportName: String
) {
    val finalContent = if (reportName.length > 80) reportName.take(80) + "..." else reportName
    val header = "Report Summary of $content"

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    var isEnglishLanSelected by remember { mutableStateOf(true) }
    var isHindiLanSelected by remember { mutableStateOf(false) }

    var translatedText by remember { mutableStateOf(reportName) }
    var translatedHeader by remember { mutableStateOf(header) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(isHindiLanSelected) {
        if (isHindiLanSelected) {
            isLoading = true
            val result = Translator.convertToHindi(reportName)
            val headerResult = Translator.convertToHindi(header)
            translatedText = result
            translatedHeader = headerResult
            isLoading = false
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextButton(
                        onClick = { showBottomSheet = false },
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null, tint = Color.Black)
                            Text(text = "Back", fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                    }
                    Row {
                        IconButton(
                            onClick = {
                                if (isEnglishLanSelected) isEnglishLanSelected = false else isEnglishLanSelected = true
                                if (!isHindiLanSelected) isHindiLanSelected = true else isHindiLanSelected = false
                            }
                        ) {
                            Icon(Icons.Default.Edit, contentDescription = null)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.AddCircle, contentDescription = null)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Share, contentDescription = null)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Delete, contentDescription = null)
                        }
                    }
                }

                if (isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 150.dp, horizontal = 150.dp)
                            .wrapContentHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        CircularProgressIndicator(
                            color = BlueColor
                        )
                    }
                } else {

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = if (isHindiLanSelected) translatedHeader else header,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = if (isHindiLanSelected) translatedText else reportName,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .clickable { showBottomSheet = true }
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = content,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = finalContent,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
