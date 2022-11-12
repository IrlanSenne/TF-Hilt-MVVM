package com.original.tipsfootball.model

import com.google.gson.annotations.SerializedName

data class PredictionsEntity(
    var response: ArrayList<ResponsePrediction>
)

data class ResponsePrediction(
    var predictions: PredictionsResponse,
    var league: LeagueResponsePredictions,
    var teams: TeamsResponsePredictions,
    var comparison: ComparisonResponsePredictions,
    //var h2h: H2hResponsePredictions
)

data class PredictionsResponse(
    var winner: WinnerPredictions,
    var win_or_draw: Boolean = false,
    var under_over: String = "",
    var goals: GoalsPredictions,
    var advice: String = "",
    var percent: PercentPrediction
)

data class WinnerPredictions(
    var id: Int = 0,
    var name: String = "",
    var comment: String = ""

)

data class GoalsPredictions(
    var home: String = "",
    var away: String = ""
)

data class PercentPrediction(
    var home: String = "",
    var draw: String = "",
    var away: String = ""
)

data class LeagueResponsePredictions(
    var id: Int = 0,
    var name: String = "",
    var country: String = "",
    var logo: String = "",
    var flag: String = "",
    var season: Int = 0
)

data class TeamsResponsePredictions(
    var home: TeamsPred,
    var away: TeamsPred
)

data class TeamsPred(
    var id: Int = 0,
    var name: String = "",
    var logo: String = "",
    var last_5: LastFive,
    var league: LeaguePred
)

data class LastFive(
    var form: String = "",
    var att: String = "",
    var def: String = "",
    var goals: GoalsLastFive
)

data class GoalsLastFive(
    @SerializedName("for")
    var forGoals: TotalAverage,
    var against: TotalAverage
)

data class TotalAverage(
    var total: Float = 0f,
    var average: Float = 0f

)

data class LeaguePred(
    var form: String = "",
    var fixtures: Fixtures,
    var goals: GoalsLeaguePred,
    var biggest: Biggest,
    var clean_sheet: HomeAwaysTotal,
    var failed_to_score: HomeAwaysTotal

)

data class Fixtures(
    var played: HomeAwaysTotal,
    var wins: HomeAwaysTotal,
    var draws: HomeAwaysTotal,
    var loses: HomeAwaysTotal

)

data class HomeAwaysTotal(
    var home: Int = 0,
    var away: Int = 0,
    var total: Int = 0

)

data class GoalsLeaguePred(
    @SerializedName("for")
    var forGoalsLeaguePred: ForAgainstGoalsLeaguePred,
    var against: ForAgainstGoalsLeaguePred

)

data class ForAgainstGoalsLeaguePred(
    var total: TotalAverage,
    var average: TotalAverage

)

data class Biggest(
    var streak: Streak,
    var wins: HomeAway,
    var loses: HomeAway,
    var goals: GoaslBiggest

)

data class HomeAway(
    var home: String = "",
    var away: String = ""

)

data class Streak(
    var wins: String = "",
    var draws: String = "",
    var loses: String = ""
)

data class GoaslBiggest(
    @SerializedName("for")
    var forGoalsLeaguePred: HomeAway,
    var against: HomeAway
)

data class ComparisonResponsePredictions(
    var form: HomeAway,
    var att: HomeAway,
    var def: HomeAway,
    var poisson_distribution: HomeAway,
    var h2h: HomeAway,
    var goals: HomeAway,
    var total: HomeAway
)