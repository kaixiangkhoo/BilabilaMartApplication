package com.example.bilabilamartapplication.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bilabilamartapplication.data.User
import com.example.bilabilamartapplication.data.UserRepository

class SignUpViewModel(private val userRepository: UserRepository): ViewModel(){
    var userUiState by mutableStateOf(UserUiState())
        private set

    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }

    suspend fun signUp() {
        if (validateInput()) {
            userRepository.insertItem(userUiState.userDetails.toItem())
        }
    }

    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && dob.isNotBlank() && phone.isNotBlank() && email.isNotBlank()
        }
    }
}

data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

data class UserDetails(
    val userId: Int = 0,
    val title: String = "",
    val name: String = "",
    val lastName: String = "",
    val race: String = "",
    val dob: String = "",
    val phone: String = "",
    val email: String = "",
    val unit: String = "",
    val road: String = "",
    val state: String = "",
    val city: String = "",
    val postalCode: String = ""
)

fun UserDetails.toItem(): User = User(
    userId = userId,
    title = title,
    name = name,
    lastName = lastName,
    race = race,
    dob = dob,
    phone = phone,
    email = email,
    unit = unit,
    road = road,
    state = state,
    city = city,
    postalCode = postalCode
)

fun User.toUserUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)

fun User.toUserDetails(): UserDetails = UserDetails(
    userId = userId,
    title = title,
    name = name,
    lastName = lastName,
    race = race,
    dob = dob,
    phone = phone,
    email = email,
    unit = unit,
    road = road,
    state = state,
    city = city,
    postalCode = postalCode
)