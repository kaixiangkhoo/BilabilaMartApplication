package com.example.bilabilamartapplication.user

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination

object EditDeliveryAddress : NavigationDestination {
    override val route = "editdeliveryaddress"
    override val titleRes = R.string.app_name
}

@Composable
fun EditDeliveryAddress(){

}

@Preview(showBackground = true)
@Composable
fun PreviewEditDeliveryAddress(){
    EditDeliveryAddress()
}