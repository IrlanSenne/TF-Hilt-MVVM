package com.senne.footballltips.usecase

import com.senne.footballltips.model.PredictionsEntity
import kotlinx.coroutines.flow.Flow

interface GetTipUseCase {
    suspend operator fun invoke(fixture: String): Flow<PredictionsEntity?>
}