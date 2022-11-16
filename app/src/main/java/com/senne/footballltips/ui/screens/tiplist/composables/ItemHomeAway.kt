package com.senne.footballltips.ui.screens.tiplist.composables

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.senne.footballltips.model.TipsEntity
import com.senne.footballltips.ui.widgets.TipButton
import com.senne.footballltips.ui.widgets.TipText

@Composable
fun ItemHomeAway(tipsEntity: TipsEntity) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TipText(text = tipsEntity.league?.country ?: "")

            TipText(modifier = Modifier.padding(horizontal = 8.dp), text = "-")

            TipText(text = tipsEntity.league?.name ?: "")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = rememberAsyncImagePainter(tipsEntity.home_photo),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                TipText(
                    text = "${tipsEntity.home_name}", textAlign = TextAlign.Center
                )
            }

            TipButton(
                text = tipsEntity.id.toString(),
                modifier = Modifier.width(80.dp).height(36.dp),
                onClick = {
                    Toast.makeText(context, "test", Toast.LENGTH_LONG).show()
                }
            )

            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(tipsEntity.away_photo),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                TipText(
                    text = "${tipsEntity.away_name}", textAlign = TextAlign.Center
                )
            }
        }
    }
}