package com.senne.footballltips.usecase

import com.senne.footballltips.data.TipsRepository
import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetTipsUseCaseImpl @Inject constructor(
     private val tipsRepository: TipsRepository
): GetTipsUseCase {
    override suspend fun invoke(): MutableList<TipsEntity> {
        tipsRepository.insertTipsFirebase()

        var a = tipsRepository.getTipsApi("2022-11-12")
        var b = a

        delay(1000)

        return tipsRepository.getTipsFirebaseCall()
    }
}
