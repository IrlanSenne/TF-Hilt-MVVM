package com.senne.footballltips.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TipButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            TipText(text = text)
        }
    }
}