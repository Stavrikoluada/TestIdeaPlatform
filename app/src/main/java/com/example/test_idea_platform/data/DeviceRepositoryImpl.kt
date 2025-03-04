package com.example.test_idea_platform.data

import com.example.test_idea_platform.data.db.AppDatabase
import com.example.test_idea_platform.data.db.DeviceEntity
import com.example.test_idea_platform.data.test_data.TestData
import com.example.test_idea_platform.domain.DeviceModel
import com.example.test_idea_platform.domain.DeviceRepository

class DeviceRepositoryImpl : DeviceRepository {

    private val db = AppDatabase.instance

    override fun insertDevicesToRepository(devises: DeviceModel) {
        db.deviceDao().insertDevices(
            DeviceEntity(
                id = devises.id,
                name = devises.name,
                time = devises.time,
                tags = devises.tags.joinToString(separator = ","),
                amount = devises.amount
            )
        )
    }

    override fun getRepositoryDevices(): List<DeviceModel> {
        return db.deviceDao().getDevices().map { items ->
            DeviceModel(
                id = items.id,
                name = items.name,
                time = items.time,
                tags = items.tags.split(",").let { ArrayList(it) },
                amount = items.amount
            )
        }
    }

    override fun getRepositoryForId(id: Int): DeviceModel {
        val deviceDao =  db.deviceDao().getDeviceForId(id)
        return DeviceModel(
            id = deviceDao.id,
            name = deviceDao.name,
            time = deviceDao.time,
            tags = deviceDao.tags.split(",").let { ArrayList(it) },
            amount = deviceDao.amount
        )
    }

    override fun deleteRepositoryDeviceById(id: Int) {
        db.deviceDao().deleteDeviceById(id)
    }

    override fun changeRepositoryAmountDeviceById(id: Int, newAmount: Int) {
        db.deviceDao().changeAmountDeviceById(id, newAmount)
    }

    override fun getTestData(): List<DeviceModel>  {
        return TestData.getTestData()
    }
}