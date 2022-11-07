package com.original.tipsfootball.usecase

import com.original.tipsfootball.model.TipsEntity

interface GetTipsUseCase {
    suspend operator fun invoke(): MutableList<TipsEntity>
}