package com.example.test_idea_platform.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.test_idea_platform.data.db.DatabaseHelper
import com.example.test_idea_platform.presentation.di.Application
import com.example.test_idea_platform.presentation.screens.MainScreen
import com.example.test_idea_platform.ui.theme.TestIdeaPlatformTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val databaseHelper = DatabaseHelper(this)
        databaseHelper.copyDatabaseFromAssets()

        (application as Application).appComponent.inject(this)

        enableEdgeToEdge()
        setContent {
            TestIdeaPlatformTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}