package com.example.test_idea_platform.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.test_idea_platform.R
import com.example.test_idea_platform.presentation.DeviceUiState
import com.example.test_idea_platform.presentation.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val deviceState by viewModel.deviceState.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredDevices = when (deviceState) {
        is DeviceUiState.Loading -> emptyList()
        is DeviceUiState.Success -> {
            val devices = (deviceState as DeviceUiState.Success).devices
            devices.filter { it.name.contains(searchQuery, ignoreCase = true) }
        }

        else -> emptyList()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 90.dp),
                        text = stringResource(id = R.string.list_products)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF9AC7FA),
                    titleContentColor = Color.Black
                )
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color(0xFFEFEFEF)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        SearchScreen(onSearchQueryChanged = { query -> searchQuery = query })
                    }

                    itemsIndexed(filteredDevices) { _, device ->
                        ItemScreen(device, viewModel)
                    }
                }
            }
        }
    }
}