package com.senne.footballltips.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.senne.footballltips.common.*
import com.senne.footballltips.data.TipsRepository
import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.delay
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

class GetTipsUseCaseImpl @Inject constructor(
    private val tipsRepository: TipsRepository
) : GetTipsUseCase {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun invoke(): MutableList<TipsEntity> {

        val date = LocalDate.now().toString()

        var tipsEntity = tipsRepository.getTipsFirebaseCall()
        var listGames = mutableListOf<HashMap<String, Serializable>>()

        // Get data games from api
        var tipsApi = tipsRepository.getTipsApi(date)

        tipsApi?.response?.map {
            if (it.fixture?.status?.long == "In Progress" || it.fixture?.status?.long == "Not Started")
                listGames.add(
                    hashMapOf(
                        HOME_NAME to (it.teams?.home?.name ?: "-"),
                        HOME_PHOTO to (it.teams?.home?.logo ?: "-"),
                        AWAY_NAME to (it.teams?.away?.name ?: "-"),
                        AWAY_PHOTO to (it.teams?.away?.logo ?: "-"),
                        DATE_FIXTURE to date
                    )
                )
        }

        if (tipsEntity.isNullOrEmpty()) {
            tipsRepository.insertTipsFirebase(listGames)

            tipsEntity = tipsRepository.getTipsFirebaseCall()
        } else {
            if (tipsEntity[0].date != "2022-11-13") {
                tipsRepository.deleteOldTipsFirebase()
               // tipsRepository.insertTipsFirebase(listGames)

                delay(1000)
                tipsEntity = tipsRepository.getTipsFirebaseCall()
            }
        }

        delay(2000)

        return tipsEntity
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
