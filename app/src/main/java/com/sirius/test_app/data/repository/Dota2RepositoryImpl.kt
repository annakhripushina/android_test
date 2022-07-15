package com.sirius.test_app.data.repository

import com.sirius.test_app.data.model.DataModel
import com.sirius.test_app.domain.repository.Dota2Repository
import javax.inject.Inject

class Dota2RepositoryImpl @Inject constructor() : Dota2Repository {
    override fun getData(): DataModel =
        DataModel()
}