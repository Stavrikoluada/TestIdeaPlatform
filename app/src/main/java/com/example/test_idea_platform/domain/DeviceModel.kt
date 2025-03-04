package com.example.test_idea_platform.domain

data class DeviceModel (
    val id: Int,
    val name: String,
    val time: Long,
    val tags: ArrayList<String>,
    val amount: Int,
)