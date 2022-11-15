package com.senne.footballltips.ui.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun TipText(
    value: String,
    textAlign: TextAlign,
    fontSize: TextUnit
) {

    Text(
        text = value,
        textAlign = textAlign,
        fontSize = fontSize
    )
}