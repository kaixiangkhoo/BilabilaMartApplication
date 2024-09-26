package com.example.bilabilamartapplication.user

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination

object EditProfile : NavigationDestination {
    override val route = "editprofile"
    override val titleRes = R.string.app_name
}

@Composable
fun EditProfileScreen(
//    viewModel: ProfileViewModel = viewModel(),
    onSaveClick: () -> Unit,
    onNavigateUp: () -> Unit
) {
    // State variables for user input
    var title by remember { mutableStateOf("Mr.") }
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var race by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("") }
    var road by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }

    // Use rememberScrollState to maintain scroll position
    val scrollState = rememberScrollState()
    val dob = "01 Jan 2000"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState) // Enable scrolling
    ) {
        // Top Section: Title, Profile Image, and Name
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = onNavigateUp) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Edit My Profile",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Profile Image and Name
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF00BCD4))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile",
                modifier = Modifier.size(100.dp),
                tint = Color.White
            )
            Text(
                text = "$name $lastName",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Basic Information
        Text(text = "Basic Information", style = MaterialTheme.typography.headlineSmall)

        //Title
        DropdownMenu(
            label = "Title",
            selectedItem = title,
            options = titleOptions,
            onItemSelected = { title = it } // Handle selection change
        )

        //First name
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it // Update local state
            },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        //Last name
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it }, // Update last name state
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        //Race
        OutlinedTextField(
            value = race,
            onValueChange = { race = it }, // Update race state
            label = { Text("Race") },
            modifier = Modifier.fillMaxWidth()
        )

        //DoB
        OutlinedTextField(
            value = dob,
            onValueChange = { /* No-op */ }, // No-op since it's read-only
            label = { Text("Date of Birth (DD/MM/YYYY)") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false // Disable editing
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contact Info
        Text(text = "Contact Info", style = MaterialTheme.typography.headlineSmall)

        //Phone
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it }, // Update phone state
            label = { Text("Mobile Number") },
            modifier = Modifier.fillMaxWidth()
        )

        //Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it }, // Update email state
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Address Info
        Text(text = "Address", style = MaterialTheme.typography.headlineSmall)

        //Unit
        OutlinedTextField(
            value = unit,
            onValueChange = { unit = it }, // Update unit state
            label = { Text("Unit No./Block/Building") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = road,
            onValueChange = { road = it }, // Update road state
            label = { Text("Road") },
            modifier = Modifier.fillMaxWidth()
        )

        //State
        DropdownMenu(
            label = "State",
            selectedItem = state,
            options = stateOptions,
            onItemSelected = { state = it } // Handle selection change
        )

        //City
        DropdownMenu(
            label = "City",
            selectedItem = city,
            options = cityOptions,
            onItemSelected = { city = it } // Handle selection change
        )

        OutlinedTextField(
            value = postalCode,
            onValueChange = { postalCode = it }, // Update postal code state
            label = { Text("Postal Code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Save Button
        Button(
            onClick = { onSaveClick() },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Save")
        }
    }
}

@Composable
fun DropdownMenu(
    label: String,
    selectedItem: String,
    options: List<String>,
    onItemSelected: (String) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(selectedItem) }

    Column {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            label = { Text(label) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            trailingIcon = {
                Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) }, // Correct way to pass text in the new API
                    onClick = {
                        selectedText = option
                        expanded = false
                        onItemSelected(option)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(
        onSaveClick = { /* Handle Save action */ },
        onNavigateUp = { /* Do Nothing */ }
    )
}
