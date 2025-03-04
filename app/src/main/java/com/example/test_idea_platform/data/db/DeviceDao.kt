package com.example.test_idea_platform.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeviceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDevices(devises: DeviceEntity)

    @Query("SELECT * FROM item")
    fun getDevices(): List<DeviceEntity>

    @Query("SELECT * FROM item WHERE id = :id")
    fun getDeviceForId(id: Int): DeviceEntity

    @Query("DELETE FROM item WHERE id = :id")
    fun deleteDeviceById(id: Int)

    @Query("UPDATE item SET amount = :newAmount WHERE id = :id")
    fun changeAmountDeviceById(id: Int, newAmount: Int)
}