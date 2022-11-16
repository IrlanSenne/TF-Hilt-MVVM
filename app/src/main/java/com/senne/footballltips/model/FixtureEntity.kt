package com.senne.footballltips.model

data class FixtureEntity (
    var response: ArrayList<ResponseFixture>? = null
)

data class ResponseFixture (
    var fixture: Fixture? = null,
    var league: League? = null,
    var teams: TeamsFixture? = null,
    var goals: GoalsBothTeams? = null
)

data class Fixture (
    var id: Long? = null,
    var status: StatusFixture? = null
)

data class TeamsFixture(
    var home: DetailsTeam? = null,
    var away: DetailsTeam? = null
)

data class DetailsTeam(
    var name: String? = null,
    var logo: String? = null,
    var winner: Boolean? = null
)

data class StatusFixture(
    var long: String? = null,
    var short: String? = null,
    var elapsed: Int? = null
)

data class GoalsBothTeams(
    var home: Int? = null,
    var away: Int? = null
)

data class League(
    var name: String? = null,
    var country: String? = null,
    var flag: String? = null
)