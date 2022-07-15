package com.sirius.test_app.domain.repository

import com.sirius.test_app.data.model.DataModel

interface Dota2Repository {
    fun getData(): DataModel
}