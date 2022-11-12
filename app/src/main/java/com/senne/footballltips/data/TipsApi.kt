package com.senne.footballltips.data

import com.senne.footballltips.model.FixtureEntity
import com.original.tipsfootball.model.PredictionsEntity
import retrofit2.http.*

interface TipsApi {
    @Headers("x-rapidapi-key: c82fadd1860d1c49bd3f13f30797d689", "x-rapidapi-host: v3.football.api-sports.io")
    @GET("fixtures")
    suspend fun listFixture(@Query("date") date: String): FixtureEntity?
    //@Query("id") id: String, @Query("season") season: String

    @Headers("x-rapidapi-key: c82fadd1860d1c49bd3f13f30797d689", "x-rapidapi-host: v3.football.api-sports.io")
    @GET("predictions")
    fun listPredictions(@Query("fixture") fixture: String): PredictionsEntity
}