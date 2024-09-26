package com.example.bilabilamartapplication.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination

object LogIn : NavigationDestination {
    override val route = "login"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top bar with time and close button
        TopAppBar(
            actions = {
                IconButton(onClick = { /* Handle close button click */ }) {
                    Icon(Icons.Filled.Close, contentDescription = "Close")
                }
            },
            title = { Text("Login") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Lotus's logo and text
        Image(
            painter = painterResource(id = R.drawable.bilabila),
            contentDescription = "Lotus's Logo",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "bilabilamart",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.primary
        )

        // First time login message
        Text(
            text = "First time login as member? Click here",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clickable { /* Handle click */ },
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )

        // Country code and mobile number input
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = "+60", // Use a fixed value for country code
                onValueChange = { },
                modifier = Modifier.weight(1f),
                label = { Text("Country Code") },
                readOnly = true
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(2f),
                label = { Text("Mobile Number") }
            )
        }

        // Password input
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            trailingIcon = {
                Icon(Icons.Filled.Lock, contentDescription = "Toggle password visibility")
            }
        )

        // Login button
        Button(
            onClick = { /* Handle login click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Login", style = MaterialTheme.typography.labelLarge)
        }

        // Forgot password link
        TextButton(
            onClick = { /* Handle forgot password click */ },
            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the button
        ) {
            Text("Forgot Password?", color = MaterialTheme.colorScheme.primary)
        }

        // Register link
        TextButton(
            onClick = { /* Handle register click */ },
            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the button
        ) {
            Text("New customer? Register Now", color = MaterialTheme.colorScheme.primary)
        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun LoginScreenPreview() {
    LogInScreen()
}

