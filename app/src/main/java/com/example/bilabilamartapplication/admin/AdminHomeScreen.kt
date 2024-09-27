package com.example.bilabilamartapplication.admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bilabilamartapplication.AppTopAppBar
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination
import com.example.bilabilamartapplication.ui.theme.BilabilaMartApplicationTheme

object AdminHomeScreen : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen(
    navigateToInventory: () -> Unit,
    navigateToProfile : () -> Unit,
    navigateToLogIn: () -> Unit,
    //onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                title = "Select an Option",
                canNavigateBack = true,
                //navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                )
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = navigateToInventory, modifier = Modifier.padding(8.dp)) {
                Text("Inventory")
            }
            Button(onClick = { /* Handle Announcement Click */ }, modifier = Modifier.padding(8.dp)) {
                Text("Announcement")
            }
            Button(onClick = navigateToProfile, modifier = Modifier.padding(8.dp)) {
                Text("Profile")
            }
            Button(onClick = navigateToLogIn, modifier = Modifier.padding(8.dp)) {
                Text("Log In")
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AdminHomeScreen(
//    modifier: Modifier = Modifier,
//    navigateToInventory: () -> Unit,
//) {
//    Column (
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        AppTopAppBar(
//                title = stringResource(Inventory.titleRes),
//                canNavigateBack = false,
//            )
//
//        Row {
//            Button (//navigateToInventory
//                onClick = navigateToInventory
//            )
//            {
//                Text(text = "Inventory")
//            }
//        }
//
//        Row {
//            Button(onClick = { /*TODO*/ }) {
//                Text(text = "Announcement")
//            }
//        }
//
//        }
//
//
//
//    }




@Preview(showBackground = true)
@Composable
fun AdminHomeScreenPreview(){
    BilabilaMartApplicationTheme{
        // Mock functions for navigation (no actual navigation)
        val mockNavigateToInventory: () -> Unit = {
            println("Navigating to Inventory")
        }

        val mockNavigateToProfile: () -> Unit = {
            println("Navigating to Profile")
        }
    }
}