package com.example.friends.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.friends.ui.theme.Purple200

@Composable
fun ProgressBarComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        CircularProgressIndicator(
            modifier = Modifier.padding(16.dp),
            color = Purple200,
            strokeWidth = Dp(value = 4F)
        )
    }
}