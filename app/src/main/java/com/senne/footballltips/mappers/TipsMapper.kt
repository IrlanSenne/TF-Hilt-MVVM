package com.senne.footballltips.mappers

import com.senne.footballltips.common.*
import com.senne.footballltips.model.FixtureEntity
import java.io.Serializable

fun FixtureEntity.toMutableListTipsEntity(date: String): MutableList<HashMap<String, Serializable>> {
    var listGames = mutableListOf<HashMap<String, Serializable>>()
    this?.response?.map {
        if (it.fixture?.status?.long == "In Progress" || it.fixture?.status?.long == "Not Started")
            listGames.add(
                hashMapOf(
                    ID to (it?.fixture?.id ?: "-"),
                    LEAGUE to hashMapOf(
                        LEAGUE_NAME to (it?.league?.name ?: "-"),
                        LEAGUE_COUNTRY to (it?.league?.country ?: "-")
                    ),
                    HOME_NAME to (it.teams?.home?.name ?: "-"),
                    HOME_PHOTO to (it.teams?.home?.logo ?: "-"),
                    AWAY_NAME to (it.teams?.away?.name ?: "-"),
                    AWAY_PHOTO to (it.teams?.away?.logo ?: "-"),
                    DATE_FIXTURE to date
                )
            )
    }

    return listGames
}