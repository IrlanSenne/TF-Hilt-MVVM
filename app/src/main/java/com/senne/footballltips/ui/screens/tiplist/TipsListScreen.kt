package com.senne.footballltips.ui.screens.tiplist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senne.footballltips.ui.MainViewModel
import com.senne.footballltips.ui.screens.tiplist.composables.ItemHomeAway

@Composable
fun TipsListScreen(
    mainViewModel: MainViewModel
) {
    var tipsDataFlow = mainViewModel.gamesStateFlow?.collectAsState().value
    var openAdviceScreen by remember { mutableStateOf(false) }
    var id by remember { mutableStateOf<Long?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(tipsDataFlow) {
                ItemHomeAway(
                    tipsEntity = it,
                    onClick = {
                        id = it.id
                        openAdviceScreen = true
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))
            }
        }

        AnimatedVisibility(visible = openAdviceScreen) {
            AdvicesScreen(
                id = id.toString(),
                openOnChange = {
                    openAdviceScreen = it
                    id = null
                }
            )
        }
    }
}