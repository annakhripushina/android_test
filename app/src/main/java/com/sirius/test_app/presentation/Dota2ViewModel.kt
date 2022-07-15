package com.sirius.test_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sirius.test_app.data.model.DataModel
import com.sirius.test_app.domain.usecase.GetDataDota2UseCase
import com.sirius.test_app.extensions.SingleLiveEvent
import javax.inject.Inject

class Dota2ViewModel @Inject constructor(
    private val getDataDota2UseCase: GetDataDota2UseCase
) {
    private var _data: MutableLiveData<DataModel> = SingleLiveEvent()
    val data: LiveData<DataModel> = _data

    fun getDataDota2() {
        _data.value = getDataDota2UseCase.getDataDota2()
    }
}