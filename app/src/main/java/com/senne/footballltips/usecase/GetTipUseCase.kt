package com.senne.footballltips.usecase

import com.original.tipsfootball.model.PredictionsEntity
import kotlinx.coroutines.flow.Flow

interface GetTipUseCase {
    suspend operator fun invoke(fixture: String): Flow<PredictionsEntity?>
}