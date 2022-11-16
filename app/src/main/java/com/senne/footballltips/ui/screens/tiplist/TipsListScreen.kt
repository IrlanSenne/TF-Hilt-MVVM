package com.senne.footballltips.ui.screens.tiplist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senne.footballltips.ui.MainViewModel
import com.senne.footballltips.ui.screens.tiplist.composables.ItemHomeAway

@Composable
fun TipsListScreen(
    mainViewModel: MainViewModel
) {
    var tipsDataFlow = mainViewModel.gamesStateFlow?.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        tipsDataFlow?.forEach {
            ItemHomeAway(it)

            Spacer(modifier = Modifier.height(12.dp))
            Divider(modifier = Modifier.fillMaxWidth().height(1.dp))
            Spacer(modifier = Modifier.height(30.dp))

        }
    }
}