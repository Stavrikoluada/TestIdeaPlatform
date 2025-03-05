package com.example.test_idea_platform.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.test_idea_platform.R
import com.example.test_idea_platform.presentation.MainViewModel

@Composable
fun QuantityDialog(
    deviceId: Int,
    initialAmount: Int,
    viewModel: MainViewModel,
    onDismiss: () -> Unit
) {
    var amount by remember { mutableIntStateOf(initialAmount) }


    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 30.dp)
                ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(id = R.string.settings),
                    modifier = Modifier.size(30.dp),
                    tint = Color.Gray
                )
                Text(text = stringResource(id = R.string.product_quantity),
                    style = MaterialTheme.typography.titleLarge)
            }
        },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = {
                        if (amount > 0) {
                            amount -= 1
                        }
                    }) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_remove_circle_outline_24),
                                contentDescription = stringResource(id = R.string.minus),
                                tint = Color(0xFF495377),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Text(
                        text = "$amount",
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    IconButton(onClick = {
                        amount += 1
                    }) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
                                contentDescription = stringResource(id = R.string.plus),
                                tint = Color(0xFF495377),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    viewModel.changeAmountDeviceById(deviceId, amount)
                    onDismiss()
                }
            ) {
                Text(stringResource(id = R.string.accept))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(stringResource(id = R.string.cancel))
            }
        }
    )
}
