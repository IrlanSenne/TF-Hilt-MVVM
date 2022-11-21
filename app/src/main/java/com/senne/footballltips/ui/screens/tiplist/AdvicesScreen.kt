package com.senne.footballltips.ui.screens.tiplist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.senne.footballltips.R
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.senne.footballltips.ui.MainViewModel
import com.senne.footballltips.ui.widgets.TipText

@Composable
fun AdvicesScreen(
   id: String,
   openOnChange: (Boolean) -> Unit
) {
    val mainViewModel = viewModel<MainViewModel>()

    var tipStateFlow = mainViewModel.tipStateFlow?.collectAsState().value

    mainViewModel.getTip(id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
       // predictionsResponse

        IconButton(
            onClick = { openOnChange(false) },
        ) {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        TipText(text = "${tipStateFlow?.response}")
    }
}