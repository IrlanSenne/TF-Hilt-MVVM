package com.senne.footballltips.data

import com.senne.footballltips.model.FixtureEntity
import com.original.tipsfootball.model.PredictionsEntity
import retrofit2.http.*

interface TipsApi {
    @Headers("x-rapidapi-key: c82fadd1860d1c49bd3f13f30797d689", "x-rapidapi-host: v3.football.api-sports.io")
    @GET("fixtures")
    suspend fun listFixture(@Query("date") date: String): FixtureEntity?

    @Headers("x-rapidapi-key: c82fadd1860d1c49bd3f13f30797d689", "x-rapidapi-host: v3.football.api-sports.io")
    @GET("predictions")
    suspend fun getPredictions(@Query("fixture") fixture: String): PredictionsEntity?
}