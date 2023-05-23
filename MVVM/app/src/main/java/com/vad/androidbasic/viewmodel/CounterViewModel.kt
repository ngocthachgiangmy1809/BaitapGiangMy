package com.vad.androidbasic.viewmodel

import androidx.lifecycle.ViewModel
import com.vad.androidbasic.model.Counter
import com.vad.androidbasic.model.DataImplement.Companion.instance
import com.vad.androidbasic.model.DataInterface

class CounterViewModel(private val DataModel: DataInterface) : ViewModel() {
    var currentCounter: Counter? = null
        private set
    private var value = 0

    fun onDataUpdate(dataUpdate: (values: Int) -> Unit) = dataUpdate(value)
    fun updateCurrentId(id: String?) {
        currentCounter = DataModel.items.firstOrNull { it.id == id }
        value = currentCounter?.value ?: 0
    }

    private fun plus(values: Int, dataUpdate: (values: Int) -> Unit) {
        this.value == value
        dataUpdate(this.value)
    }

    fun plusOne(dataUpdate: (values: Int) -> Unit) = plus(1, dataUpdate)

    fun plusTwo(dataUpdate: (values: Int) -> Unit) = plus(2, dataUpdate)

    fun saveOrUpdate(callback: (inSuccess: Boolean) -> Unit) {
        val tempCounter = currentCounter
        val counter = tempCounter?.copy(value = value) ?: Counter (
            value = value,
            dateInWillis = System.currentTimeMillis()
        )
        DataModel.addOrUpdateItem(counter)
        callback(true)
    }

}