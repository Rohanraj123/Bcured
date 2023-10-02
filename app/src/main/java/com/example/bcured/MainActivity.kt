package com.example.bcured


import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AssistChipDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.bcured.ui.theme.BcuredBackgroundColor
import com.example.bcured.ui.theme.BcuredTheme
import com.example.bcured.ui.theme.greenColor
import com.google.accompanist.pager.*
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        @OptIn(ExperimentalPagerApi::class)
        super.onCreate(savedInstanceState)
        setContent {
            BcuredTheme {
                TabLayout()
            }
        }
    }
}

// on below line we are creating a
// composable function for our tab layout
@OptIn(ExperimentalUnitApi::class)
@ExperimentalPagerApi
@Composable
fun TabLayout() {

    // on below line we are creating variable for pager state.
    val pagerState = rememberPagerState(pageCount = 2)

    // on below line we are creating a column for our widgets.
    Column(
        // for column we are specifying modifier on below line.
        modifier = Modifier.background(Color.LightGray)
    ) {
        // on the below line we are specifying the top app bar
        // and specifying background color for it.
        TopAppBar(backgroundColor = BcuredBackgroundColor,
            modifier = Modifier.height(173.dp)) {
            // on below line we are specifying a column
            // for our text view to display a text
            // in our top app bar.
            Column(
                modifier = Modifier.fillMaxSize(),
                // on below line we are providing alignment for our
                // column to center of our top app bar.
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // on below line we are specifying a text and
                // specifying a text as "Tab Layout Example"
                Text(
                    text = "Welcome to BCURED !",
                    style = TextStyle(color = Color.White),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = TextUnit(
                        18F,
                        TextUnitType.Sp
                    ),
                    // on below line we are specifying a modifier
                    // to our text and adding passing from all sides.
                    modifier = Modifier
                        .padding(all = Dp(5F)),
                    // on below line we are aligning
                    // our text to center.
                    textAlign = TextAlign.Center
                )
            }
        }
        // on below line we are calling tabs
        Tabs(pagerState = pagerState)
        // on below line we are calling tabs content
        // for displaying our page for each tab layout
        TabsContent(pagerState = pagerState)
    }
}

// on below line we are
// creating a function for tabs
@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "LogIn" to Icons.Rounded,
        "Sign Up" to Icons.Rounded
    )
    // on below line we are creating
    // a variable for the scope.
    val scope = rememberCoroutineScope()
    // on below line we are creating a
    // individual row for our tab layout.
    TabRow(
        // on below line we are specifying
        // the selected index.
        selectedTabIndex = pagerState.currentPage,

        // on below line we are
        // specifying background color.
        backgroundColor = BcuredBackgroundColor,

        // on below line we are specifying content color.
        contentColor = Color.White,

        // on below line we are specifying
        // the indicator for the tab
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        // on below line we are specifying icon
        // and text for the individual tab item
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                // on below line we are specifying icon
                // for each tab item and we are calling
                // image from the list which we have created.
                // on below line we are specifying the text for
                // the each tab item and we are calling data
                // from the list which we have created.
                text = {
                    Text(
                        list[index].first,
                        // on below line we are specifying the text color
                        // for the text in that tab
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                // on below line we are specifying
                // the tab which is selected.
                selected = pagerState.currentPage == index,
                // on below line we are specifying the
                // on click for the tab which is selected.
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

// on below line we are creating a tab content method
// in which we will be displaying the individual page of our tab .
@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            // on below line we are calling tab content screen
            // and specifying data as Home Screen.
            0 -> LogInFunction()
            // on below line we are calling tab content screen
            // and specifying data as Shopping Screen.
            1 -> SignUpFunction()
        }
    }
}

// on below line we are creating a Tab Content
// Screen for displaying a simple text message.
@Composable
fun LogInFunction() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Email Text Field
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = { /* Handle email input here */ },
            label = { Text(
                text = "Email",
                color = Color.Black
            ) }
        )

        // Password Text Field
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = { /* Handle password input here */ },
            label = { Text(
                text = "Password",
                color = Color.Black
            ) },
            visualTransformation = PasswordVisualTransformation()
        )

        // Forgot Password Text (clickable)
        Text(
            text = "Forgot Password?",
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .clickable
                { /* Handle forgot password click here */ }
                .padding(top = 50.dp)
        )

        // Login Button
        Box(
            modifier = Modifier
                .clickable {
                    mutableStateOf(true)
                    /*Logic to be executed here*/
                }
                .fillMaxWidth()
                .background(BcuredBackgroundColor)
                .padding(top = 20.dp)
                .height(37.dp),
            contentAlignment = Alignment.Center,
            content = {
                Text(
                    text = "SignUp",
                    color = Color.White,
                    fontSize = 15.sp,
                )
            }
        )

        // Authentication with Google Button
        Box(
            modifier = Modifier
                .clickable {
                    mutableStateOf(true)
                    /*Logic to be executed here*/
                }
                .fillMaxWidth()
                .background(BcuredBackgroundColor)
                .padding(top = 20.dp)
                .height(37.dp),
            contentAlignment = Alignment.Center,
            content = {
                Text(
                    text = "LogIn with Google",
                    color = Color.White,
                    fontSize = 15.sp,
                )
            }
        )
    }
}

@Composable
fun SignUpFunction() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Email Text Field
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = { /* Handle email input here */ },
            label = {
                Text(
                    text = "Email",
                    color = Color.Black
                )
            }
        )

        // Password Text Field
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = { /* Handle password input here */ },
            label = { Text(
                text = "Password",
                color = Color.Black
            ) },
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = { /* Handle password input here */ },
            label = { Text(
                text = "Password",
                color = Color.Black
            ) },
            visualTransformation = PasswordVisualTransformation()
        )
        // Sign Up Button
        Box(
            modifier = Modifier
                .clickable {
                    mutableStateOf(true)
                    /*Logic to be executed here*/
                }
                .fillMaxWidth()
                .padding(top = 56.dp)
                .background(BcuredBackgroundColor)
                .height(37.dp),
            contentAlignment = Alignment.Center,
            content = {
                Text(
                    text = "SignUp",
                    color = Color.White,
                    fontSize = 15.sp,
                )
            }
        )
    }
}

