package com.senne.footballltips.usecase

import com.senne.footballltips.common.*
import com.senne.footballltips.data.TipsRepository
import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.delay
import java.io.Serializable
import javax.inject.Inject

class GetTipsUseCaseImpl @Inject constructor(
    private val tipsRepository: TipsRepository
) : GetTipsUseCase {
    override suspend fun invoke(): MutableList<TipsEntity> {

        var tipsEntity = tipsRepository.getTipsFirebaseCall()
        var listGames = mutableListOf<HashMap<String, Serializable>>()
        var tipsApi = tipsRepository.getTipsApi("2022-11-14")

        tipsApi?.response?.map {

            if (it.fixture?.status?.long == "In Progress" || it.fixture?.status?.long == "Not Started")
                listGames.add(
                    hashMapOf(
                        HOME_NAME to (it.teams?.home?.name ?: "-"),
                        HOME_PHOTO to (it.teams?.home?.logo ?: "-"),
                        AWAY_NAME to (it.teams?.away?.name ?: "-"),
                        AWAY_PHOTO to (it.teams?.away?.logo ?: "-"),
                        DATE_FIXTURE to "2022-11-14"
                    )
                )
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

        // var listGames = listOf(gameInformations, gameInformations, gameInformations)
        if (tipsEntity.isNullOrEmpty()) {
            tipsRepository.insertTipsFirebase(listGames)
        } else {
            if (tipsEntity[0].date != "2022-11-14") {
                // TODO: delete data from firebase
                tipsRepository.insertTipsFirebase(listGames)
            }
        }

        delay(2000)

        return tipsEntity
    }
}
