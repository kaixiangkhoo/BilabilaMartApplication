package com.example.bilabilamartapplication.user

// ProfileViewModel.kt
import androidx.lifecycle.ViewModel


class ProfileViewModel : ViewModel() {
//    // MutableLiveData for holding profile data
//    private val _profileState = MutableLiveData<User>()
//    val profileState: LiveData<User> get() = _profileState
//
//    init {
//        // Load initial profile data
//        loadProfile()
//    }
//
//    // Function to load profile data (this could be from a database or network)
//    private fun loadProfile() {
//        // Example of loading data (this could be replaced with actual data fetching logic)
//        val initialProfile = User(
//            title = "Mr.",
//            name = "John",
//            lastName = "Doe",
//            race = "Asian",
//            phone = "+60123456789",
//            email = "john.doe@example.com",
//            unit = "A1",
//            road = "Main Street",
//            state = "Selangor",
//            city = "Shah Alam",
//            postalCode = "40000"
//        )
//        _profileState.value = initialProfile
//    }
//
//    // Function to update the profile
//    fun updateProfile(
//        title: String,
//        name: String,
//        lastName: String,
//        race: String,
//        phone: String,
//        email: String,
//        unit: String,
//        road: String,
//        state: String,
//        city: String,
//        postalCode: String
//    ) {
//        // Create a new Profile object with updated data
//        val updatedProfile = User(
//            title, name, lastName, race, phone, email, unit, road, state, city, postalCode
//        )
//
//        // Update the LiveData with the new profile
//        _profileState.value = updatedProfile
//
//        // Here you would save the updated profile to a database or make a network request
//        // saveProfileToDatabase(updatedProfile) // Placeholder for saving logic
//    }
}
