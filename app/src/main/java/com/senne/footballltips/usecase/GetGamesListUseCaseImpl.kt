package com.senne.footballltips.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.senne.footballltips.common.*
import com.senne.footballltips.data.TipsRepository
import com.senne.footballltips.mappers.toMutableListTipsEntity
import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class GetGamesListUseCaseImpl @Inject constructor(
    private val tipsRepository: TipsRepository
) : GetGamesListUseCase {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun invoke(): Flow<MutableList<TipsEntity>> = flow {

        val date = LocalDate.now().toString()
        var tipsEntity = tipsRepository.getTipsFirebaseCall()

        if (tipsEntity.isNullOrEmpty()) {
            var tipsApi = tipsRepository.getGamesApi(date)?.toMutableListTipsEntity(date)
            tipsRepository.insertTipsFirebase(tipsApi ?: mutableListOf())

            emit(tipsRepository.getTipsFirebaseCall())
        } else {
            if (tipsEntity[0].date != date) {
                var tipsApi = tipsRepository.getGamesApi(date)?.toMutableListTipsEntity(date)
                tipsRepository.deleteOldTipsFirebase()

                delay(1500)
                tipsRepository.insertTipsFirebase(tipsApi ?: mutableListOf())
            }

            delay(2000)
            emit(tipsRepository.getTipsFirebaseCall())
        }
    }
}

/*      val gameInformations = hashMapOf(
            "home_name" to "Benfica3",
            "home_photo" to "https:sjdkajksad.jpg",
            "visitant_name" to "Varzim3",
            "visitant_photo" to "https:sjdkajksad.jpg",
            "tip" to hashMapOf(
                "advice" to "varzim or draw",
                "combo_advice" to "varzim or draw adn + 4.5"
            )
        )*/