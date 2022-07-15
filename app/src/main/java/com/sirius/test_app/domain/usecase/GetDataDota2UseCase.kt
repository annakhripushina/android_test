package com.sirius.test_app.domain.usecase

import com.sirius.test_app.data.model.DataModel
import com.sirius.test_app.domain.repository.Dota2Repository
import javax.inject.Inject

class GetDataDota2UseCase @Inject constructor(private val dota2Repository: Dota2Repository) {
    fun getDataDota2(): DataModel = dota2Repository.getData()
}