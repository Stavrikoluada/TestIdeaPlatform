package com.example.test_idea_platform.presentation

import com.example.test_idea_platform.domain.DeviceModel

sealed class DeviceUiState {
    object Loading : DeviceUiState()
    data class Success(val devices: List<DeviceModel>) : DeviceUiState()
    data class Error(val errorMessage: String) : DeviceUiState()
}