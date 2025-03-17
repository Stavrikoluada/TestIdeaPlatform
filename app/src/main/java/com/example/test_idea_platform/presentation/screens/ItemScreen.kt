package com.example.test_idea_platform.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.test_idea_platform.R
import com.example.test_idea_platform.domain.DeviceModel
import com.example.test_idea_platform.presentation.MainViewModel
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemScreen(
    device: DeviceModel,
    viewModel: MainViewModel
) {
    var showDialogDelete by remember { mutableStateOf(false) }
    var showDialogQuantity by remember { mutableStateOf(false) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(16.dp)

    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = device.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = { showDialogQuantity = true }) {
                        Icon(imageVector = Icons.Default.Edit,
                            contentDescription = stringResource(id = R.string.edit),
                            tint = Color(0xFF9B4DFF))
                    }
                    IconButton(onClick = { showDialogDelete = true }) {
                        Icon(imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(id = R.string.delete),
                            tint = Color(0xFFFF7043))
                    }
                }
            }

            if (device.tags[0] != "") {
                FlowRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    device.tags.forEach { tag ->
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier.padding(4.dp),
                            border = BorderStroke(1.dp, Color.Black),
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Text(
                                text = tag,
                                color = Color.Black
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.in_stock),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = if (device.amount == 0) {
                            stringResource(id = R.string.out_of_stock)
                        } else {
                            device.amount.toString()
                        },
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.date_added),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = formatDate(device.time),
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }

    if (showDialogDelete) {
        DeleteDialog(
            deviceId = device.id,
            viewModel = viewModel,
            onDismiss = { showDialogDelete = false }
        )
    }

    if (showDialogQuantity) {
        QuantityDialog(
            deviceId = device.id,
            initialAmount = device.amount,
            viewModel = viewModel,
            onDismiss = { showDialogQuantity = false }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(time: Long): String {
    val instant = Instant.ofEpochMilli(time)
    val date = instant.atZone(ZoneId.systemDefault()).toLocalDate()
    return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
}






