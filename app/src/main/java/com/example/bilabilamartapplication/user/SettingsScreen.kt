package com.example.bilabilamartapplication.user

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination

object SettingsScreen : NavigationDestination {
    override val route = "settings"
    override val titleRes = R.string.app_name
}

@Composable
fun SettingsScreen(){

}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen(){
    SettingsScreen()
}