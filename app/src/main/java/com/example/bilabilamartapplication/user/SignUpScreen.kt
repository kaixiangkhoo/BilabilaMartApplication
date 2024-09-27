package com.example.bilabilamartapplication.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bilabilamartapplication.AppTopAppBar
import com.example.bilabilamartapplication.AppViewModelProvider
import com.example.bilabilamartapplication.R
import com.example.bilabilamartapplication.navigation.NavigationDestination
import kotlinx.coroutines.launch

object SignUp : NavigationDestination {
    override val route = "sign_up"
    override val titleRes = R.string.sign_up
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    viewModel: SignUpViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AppTopAppBar(
                title = stringResource(R.string.sign_up),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->
        SignUpBody(
            signUpUiState = viewModel.userUiState,
            onUserValueChange = viewModel::updateUiState,
            onSignUpClick = {
                coroutineScope.launch {
                    viewModel.signUp() // Trigger the sign-up process
                    navigateBack() // Navigate back after sign-up
                }
            },
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                )
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

@Composable
fun SignUpBody(
    signUpUiState: UserUiState,
    onUserValueChange: (UserDetails) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large))
    ) {
        Text(text = "Basic Information", style = MaterialTheme.typography.headlineSmall)

        // Title Dropdown
        CustomDropdownMenu(
            label = "Title",
            selectedItem = signUpUiState.userDetails.title,
            options = titleOptions,
            onItemSelected = { onUserValueChange(signUpUiState.userDetails.copy(title = it)) }
        )

        // First Name
        OutlinedTextField(
            value = signUpUiState.userDetails.name,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(name = it)) },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Last Name
        OutlinedTextField(
            value = signUpUiState.userDetails.lastName,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(lastName = it)) },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Race
        OutlinedTextField(
            value = signUpUiState.userDetails.race,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(race = it)) },
            label = { Text("Race") },
            modifier = Modifier.fillMaxWidth()
        )

        // Date of Birth (DoB) with Calendar Picker
        OutlinedTextField(
            value = signUpUiState.userDetails.dob,
            onValueChange = { /* Date will be selected from DatePicker */ },
            label = { Text("Date of Birth (DD/MM/YYYY)") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Show date picker */ }, // Show date picker on click
            readOnly = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Contact Info", style = MaterialTheme.typography.headlineSmall)

        // Phone
        OutlinedTextField(
            value = signUpUiState.userDetails.phone,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(phone = it)) },
            label = { Text("Mobile Number") },
            modifier = Modifier.fillMaxWidth()
        )

        // Email
        OutlinedTextField(
            value = signUpUiState.userDetails.email,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(email = it)) },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Address", style = MaterialTheme.typography.headlineSmall)

        // Unit
        OutlinedTextField(
            value = signUpUiState.userDetails.unit,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(unit = it)) },
            label = { Text("Unit No./Block/Building") },
            modifier = Modifier.fillMaxWidth()
        )

        // Road
        OutlinedTextField(
            value = signUpUiState.userDetails.road,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(road = it)) },
            label = { Text("Road") },
            modifier = Modifier.fillMaxWidth()
        )

        // State Dropdown
        CustomDropdownMenu(
            label = "State",
            selectedItem = signUpUiState.userDetails.state,
            options = stateOptions,
            onItemSelected = { onUserValueChange(signUpUiState.userDetails.copy(state = it)) }
        )

        // City Dropdown
        CustomDropdownMenu(
            label = "City",
            selectedItem = signUpUiState.userDetails.city,
            options = cityOptions,
            onItemSelected = { onUserValueChange(signUpUiState.userDetails.copy(city = it)) }
        )

        // Postal Code
        OutlinedTextField(
            value = signUpUiState.userDetails.postalCode,
            onValueChange = { onUserValueChange(signUpUiState.userDetails.copy(postalCode = it)) },
            label = { Text("Postal Code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Sign Up Button
        Button(
            onClick = onSignUpClick,
            enabled = signUpUiState.isEntryValid, // Validation flag
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign Up")
        }
    }
}

@Composable
fun CustomDropdownMenu(
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

        androidx.compose.material3.DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
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
fun SignUpBodyPreview() {
    val signUpUiState = UserUiState(
        userDetails = UserDetails(), // Initialize with default values
        isEntryValid = true // Assume the entry is valid for the preview
    )

    SignUpBody(
        signUpUiState = signUpUiState,
        onUserValueChange = { /* No action needed for preview */ },
        onSignUpClick = { /* No action needed for preview */ },
        modifier = Modifier.padding(16.dp) // Add some padding for visual spacing
    )
}
//@Composable
//fun SignUpScreen(
//    onSignUpClick: () -> Unit,
//    onNavigateUp: () -> Unit
//) {
//    // State variables for user input
//    var title by remember { mutableStateOf("Mr.") }
//    var name by remember { mutableStateOf("") }
//    var lastName by remember { mutableStateOf("") }
//    var race by remember { mutableStateOf("") }
//    var phone by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var unit by remember { mutableStateOf("") }
//    var road by remember { mutableStateOf("") }
//    var state by remember { mutableStateOf("") }
//    var city by remember { mutableStateOf("") }
//    var postalCode by remember { mutableStateOf("") }
//    var dob by remember { mutableStateOf("01 Jan 2000") }
//
//    // Use rememberScrollState to maintain scroll position
//    val scrollState = rememberScrollState()
//    val calendar = Calendar.getInstance()
//
//    // DatePickerDialog to be shown on click
//    val context = LocalContext.current
//    val datePickerDialog = DatePickerDialog(
//        context,
//        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
//            dob = "$dayOfMonth ${month + 1}, $year" // Update DOB with selected date
//        },
//        calendar.get(Calendar.YEAR),
//        calendar.get(Calendar.MONTH),
//        calendar.get(Calendar.DAY_OF_MONTH)
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(scrollState) // Enable scrolling
//    ) {
//        // Top Section: Title
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Start
//        ) {
//            IconButton(onClick = onNavigateUp) {
//                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
//            }
//            Text(
//                text = "Sign Up",
//                style = MaterialTheme.typography.headlineSmall,
//                modifier = Modifier.align(Alignment.CenterVertically)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Basic Information
//        Text(text = "Basic Information", style = MaterialTheme.typography.headlineSmall)
//
//        // Title Dropdown
//        CustomDropdownMenu(
//            label = "Title",
//            selectedItem = title,
//            options = titleOptions,
//            onItemSelected = { title = it } // Handle selection change
//        )
//
//        // First name
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it }, // Update name state
//            label = { Text("First Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Last name
//        OutlinedTextField(
//            value = lastName,
//            onValueChange = { lastName = it }, // Update last name state
//            label = { Text("Last Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Race
//        OutlinedTextField(
//            value = race,
//            onValueChange = { race = it }, // Update race state
//            label = { Text("Race") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Date of Birth (DoB) with Calendar Picker
//        OutlinedTextField(
//            value = dob,
//            onValueChange = { dob = it }, // Date will be selected from DatePicker
//            label = { Text("Date of Birth (DD/MM/YYYY)") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { datePickerDialog.show() }, // Show date picker on click
//            readOnly = true, // Make the field read-only as we're using a DatePicker
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Contact Info
//        Text(text = "Contact Info", style = MaterialTheme.typography.headlineSmall)
//
//        // Phone
//        OutlinedTextField(
//            value = phone,
//            onValueChange = { phone = it }, // Update phone state
//            label = { Text("Mobile Number") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Email
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it }, // Update email state
//            label = { Text("Email Address") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Address Info
//        Text(text = "Address", style = MaterialTheme.typography.headlineSmall)
//
//        // Unit
//        OutlinedTextField(
//            value = unit,
//            onValueChange = { unit = it }, // Update unit state
//            label = { Text("Unit No./Block/Building") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Road
//        OutlinedTextField(
//            value = road,
//            onValueChange = { road = it }, // Update road state
//            label = { Text("Road") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // State Dropdown
//        CustomDropdownMenu(
//            label = "State",
//            selectedItem = state,
//            options = stateOptions,
//            onItemSelected = { state = it } // Handle selection change
//        )
//
//        // City Dropdown
//        CustomDropdownMenu(
//            label = "City",
//            selectedItem = city,
//            options = cityOptions,
//            onItemSelected = { city = it } // Handle selection change
//        )
//
//        // Postal Code
//        OutlinedTextField(
//            value = postalCode,
//            onValueChange = { postalCode = it }, // Update postal code state
//            label = { Text("Postal Code") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Sign Up Button
//        Button(
//            onClick = { onSignUpClick() },
//            modifier = Modifier.fillMaxWidth(),
//        ) {
//            Text(text = "Sign Up")
//        }
//    }
//}
//
//@Composable
//fun CustomDropdownMenu(
//    label: String,
//    selectedItem: String,
//    options: List<String>,
//    onItemSelected: (String) -> Unit = {}
//) {
//    var expanded by remember { mutableStateOf(false) } // Controls whether the menu is open
//    var selectedText by remember { mutableStateOf(selectedItem) } // Tracks the selected item
//
//    Column {
//        OutlinedTextField(
//            value = selectedText,
//            onValueChange = { selectedText = it }, // Optional, to update the text in the text field
//            label = { Text(label) },
//            readOnly = true, // Prevent manual typing in the text field
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { expanded = true }, // Open the dropdown when clicked
//            trailingIcon = {
//                Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
//            }
//        )
//
//        // Dropdown menu
//        androidx.compose.material3.DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false } // Close the menu if clicked outside
//        ) {
//            options.forEach { option ->
//                DropdownMenuItem(
//                    text = { Text(option) },
//                    onClick = {
//                        selectedText = option // Update the text with the selected option
//                        expanded = false // Close the dropdown after selection
//                        onItemSelected(option) // Notify the parent about the selection
//                    }
//                )
//            }
//        }
//    }
//}



