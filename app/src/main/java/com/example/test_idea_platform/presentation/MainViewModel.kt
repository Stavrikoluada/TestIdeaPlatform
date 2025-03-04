package com.example.test_idea_platform.presentation

import androidx.lifecycle.ViewModel
import com.example.test_idea_platform.domain.interacror.Interactor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val interactor: Interactor
) : ViewModel() {

    private val _deviceState = MutableStateFlow<DeviceUiState>(DeviceUiState.Loading)
    val deviceState: StateFlow<DeviceUiState> = _deviceState

    init {
        interactor.getTestData().forEach { device ->
            interactor.insertDevices(device)
        }
        loadDevices()
    }

    private fun loadDevices() {
        _deviceState.value = DeviceUiState.Loading
        try {
            val devices = interactor.getDevices()
            _deviceState.value = DeviceUiState.Success(devices)
        } catch (e: Exception) {
            _deviceState.value = DeviceUiState.Error(e.localizedMessage)
        }
    }

    fun deleteDevice(id: Int) {
        interactor.deleteDeviceById(id)
        loadDevices()
    }

    fun changeAmountDeviceById(id: Int, amount: Int) {
        interactor.changeAmountDeviceById(id, amount)
        loadDevices()
    }
}