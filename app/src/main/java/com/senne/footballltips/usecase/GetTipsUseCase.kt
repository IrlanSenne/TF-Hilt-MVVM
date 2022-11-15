package com.senne.footballltips.usecase

import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.flow.Flow

interface GetTipsUseCase {
    suspend operator fun invoke(): Flow<MutableList<TipsEntity>>
}