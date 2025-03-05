package com.example.test_idea_platform.data

import com.example.test_idea_platform.data.db.AppDatabase
import com.example.test_idea_platform.domain.DeviceModel
import com.example.test_idea_platform.domain.DeviceRepository

class DeviceRepositoryImpl : DeviceRepository {

    private val db = AppDatabase.instance

    override fun getRepositoryDevices(): List<DeviceModel> {
        return db.deviceDao().getDevices().map { items ->
            DeviceModel(
                id = items.id,
                name = items.name,
                time = items.time,
                tags = items.tags
                    .replace("\"", "")
                    .replace("[", "")
                    .replace("]", "")
                    .split(", ")
                    .map { it.trim() }
                    .let { ArrayList(it) },
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
}