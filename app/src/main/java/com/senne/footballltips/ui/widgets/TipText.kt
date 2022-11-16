package com.senne.footballltips.ui.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TipText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 14.sp
) {

    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        fontSize = fontSize
    )
}