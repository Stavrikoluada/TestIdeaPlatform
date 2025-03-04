package com.example.test_idea_platform.domain

interface DeviceRepository {
    fun insertDevicesToRepository(devises: DeviceModel)
    fun getRepositoryDevices(): List<DeviceModel>
    fun getRepositoryForId(id: Int): DeviceModel
    fun deleteRepositoryDeviceById(id: Int)
    fun changeRepositoryAmountDeviceById(id: Int, newAmount: Int)
    fun getTestData(): List<DeviceModel>
}