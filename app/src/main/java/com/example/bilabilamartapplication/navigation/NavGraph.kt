package com.example.bilabilamartapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bilabilamartapplication.admin.AdminHomeScreen
import com.example.bilabilamartapplication.admin.Inventory
import com.example.bilabilamartapplication.admin.ProductDetailsDestination
import com.example.bilabilamartapplication.admin.ProductDetailsScreen
import com.example.bilabilamartapplication.admin.ProductEditDestination
import com.example.bilabilamartapplication.admin.ProductEditScreen
import com.example.bilabilamartapplication.admin.ProductEntryDestination
import com.example.bilabilamartapplication.admin.ProductEntryScreen
import com.example.bilabilamartapplication.user.EditProfile
import com.example.bilabilamartapplication.user.EditProfileScreen
import com.example.bilabilamartapplication.user.LogIn
import com.example.bilabilamartapplication.user.ProfileScreen
import com.example.bilabilamartapplication.user.UserScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
    NavHost(
        navController = navController,
        startDestination = AdminHomeScreen.route,
        modifier = modifier
    ){
        composable(route = AdminHomeScreen.route){
            AdminHomeScreen(
                navigateToInventory = { navController.navigate(Inventory.route)},
                navigateToProfile = { navController.navigate(UserScreen.route)}
            )
        }

        //
        composable(route = Inventory.route){
            Inventory(
                navigateToProductEntry = { navController.navigate(ProductEntryDestination.route) },
                navigateToProductUpdate = {
                    navController.navigate("${ProductDetailsDestination.route}/${it}")
                }
            )
        }

        //
        composable(
            route = ProductEntryDestination.route
        ){
            ProductEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        
        //Profile Screen
        composable(
            route = UserScreen.route
        ){
            ProfileScreen(
                navigateToEditProfile = {navController.navigate(EditProfile.route)}
            )
        }

        //Log In Screen
        composable(
            route = LogIn.route
        ){
//            EditProfileScreen(
//                onSaveClick = {navController.navigate(UserScreen.route)},
//                onNavigateUp = { navController.navigateUp() }
//            )
        }

        //Edit Profile Screen
        composable(
            route = EditProfile.route
        ){
            EditProfileScreen(
                onSaveClick = {navController.navigate(UserScreen.route)},
                onNavigateUp = { navController.navigateUp() }
            )
        }


        //
        composable(
            route = ProductDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ProductDetailsDestination.productIdArg) {
                type = NavType.IntType
            })
        ){
            ProductDetailsScreen(
                navigateToEditItem = { navController.navigate("${ProductEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }

        //
        composable(
            route = ProductEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ProductEditDestination.productIdArg) {
                type = NavType.IntType
            })
            ){
            ProductEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}