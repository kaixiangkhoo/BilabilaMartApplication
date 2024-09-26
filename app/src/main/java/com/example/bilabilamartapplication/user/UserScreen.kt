package com.example.bilabilamartapplication.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination

object UserScreen : NavigationDestination {
    override val route = "user"
    override val titleRes = R.string.app_name
}

@Composable
fun ProfileScreen(
    navigateToEditProfile: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ProfileHeader(navigateToEditProfile)
        OrderSection()
        AccountSection()
        SupportSection()
        //BottomNavigationBar()
    }
}

@Composable
fun ProfileHeader(navigateToEditProfile: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF00ADB5))
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_account), // Replace with real image
                        contentDescription = "Profile Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("kaixiang khoo", fontSize = 20.sp, color = Color.White)
                    Text(
                        "Edit My Profile", fontSize = 14.sp, color = Color.White.copy(alpha = 0.7f),
                        modifier = Modifier.clickable {navigateToEditProfile()}
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.White)
                Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.White)
            }
        }
    }
}

@Composable
fun OrderSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("All Orders", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OrderTab("Ongoing", Icons.Default.Lock)
            OrderTab("Previous", Icons.Default.List)
        }
    }
}

@Composable
fun OrderTab(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = label, modifier = Modifier.size(40.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun AccountSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("My Account", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        AccountOption("Payment Method", Icons.Default.Star)
        AccountOption("Delivery Address", Icons.Default.LocationOn)
    }
}

@Composable
fun AccountOption(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = label, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(label, fontSize = 16.sp)
        }
        Icon(Icons.Default.ArrowForward, contentDescription = "Navigate", modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SupportSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Support", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        SupportOption("FAQs", Icons.Default.Info)
        SupportOption("Call Center", Icons.Default.Phone, "1300131313")
        SupportOption("Email Us", Icons.Default.Email, "lotusshelpline@lotuss.com.my")
    }
}

@Composable
fun SupportOption(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, detail: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = label, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(label, fontSize = 16.sp)
        }
        detail?.let {
            Text(it, fontSize = 14.sp, textAlign = TextAlign.End, color = Color(0xFF00ADB5))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewProfileScreen() {
    ProfileScreen(navigateToEditProfile = { /*Do nothing*/ })
}

//@Composable
//fun BottomNavigationBar() {
//    BottomNavigation(
//        backgroundColor = Color.White
//    ) {
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//            selected = false,
//            onClick = { /* Navigate to Home */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Person, contentDescription = "Member") },
//            selected = false,
//            onClick = { /* Navigate to Member */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
//            selected = false,
//            onClick = { /* Navigate to Cart */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
//            selected = true,
//            onClick = { /* Already on Profile */ }
//        )
//    }
//}

//@Composable
//fun BottomNavigationItem(icon: @Composable () -> Unit, selected: Boolean, onClick: () -> Unit) {
//    TODO("Not yet implemented")
//}
//
//@Composable
//fun BottomNavigation(backgroundColor: Color, content: @Composable () -> Unit) {
//    TODO("Not yet implemented")
//}

