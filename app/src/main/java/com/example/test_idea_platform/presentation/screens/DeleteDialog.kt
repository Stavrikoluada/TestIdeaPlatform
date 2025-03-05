package com.example.test_idea_platform.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.test_idea_platform.R
import com.example.test_idea_platform.presentation.MainViewModel


@Composable
fun DeleteDialog(
    deviceId: Int,
    viewModel: MainViewModel,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = stringResource(id = R.string.warning),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.deleting_product),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        text = {
            Text(
                text = stringResource(id = R.string.really_want_to_delete),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        confirmButton = {
            TextButton(onClick = {
                viewModel.deleteDevice(deviceId)
                onDismiss()
            }) {
                Text(stringResource(id = R.string.yes))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(stringResource(id = R.string.no))
            }
        }
    )
}
