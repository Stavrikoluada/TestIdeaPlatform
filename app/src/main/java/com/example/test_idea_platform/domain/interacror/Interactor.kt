package com.example.test_idea_platform.domain.interacror

import com.example.test_idea_platform.domain.DeviceModel

interface Interactor {
    fun getDevices(): List<DeviceModel>
    fun getDeviceForId(id: Int): DeviceModel
    fun deleteDeviceById(id: Int)
    fun changeAmountDeviceById(id: Int, newAmount: Int)
}