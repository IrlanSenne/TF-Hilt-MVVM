package com.senne.footballltips.usecase

import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.flow.Flow

interface GetGamesListUseCase {
    suspend operator fun invoke(): Flow<MutableList<TipsEntity>>
}