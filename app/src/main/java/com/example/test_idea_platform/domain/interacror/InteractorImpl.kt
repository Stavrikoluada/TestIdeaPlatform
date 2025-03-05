package com.example.test_idea_platform.domain.interacror

import com.example.test_idea_platform.domain.DeviceModel
import com.example.test_idea_platform.domain.DeviceRepository

class InteractorImpl(private val deviceRepository: DeviceRepository) : Interactor {
    override fun getDevices(): List<DeviceModel> {
        return deviceRepository.getRepositoryDevices()
    }

    override fun getDeviceForId(id: Int): DeviceModel {
        return deviceRepository.getRepositoryForId(id)
    }

    override fun deleteDeviceById(id: Int) {
        return deviceRepository.deleteRepositoryDeviceById(id)
    }

    override fun changeAmountDeviceById(id: Int, newAmount: Int) {
        return deviceRepository.changeRepositoryAmountDeviceById(id, newAmount)
    }
}