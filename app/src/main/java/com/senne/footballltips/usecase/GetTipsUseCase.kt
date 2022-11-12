package com.senne.footballltips.usecase

import com.senne.footballltips.model.TipsEntity

interface GetTipsUseCase {
    suspend operator fun invoke(): MutableList<TipsEntity>
}