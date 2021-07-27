package com.wasilyk.app.poplibraries.presenter

import com.wasilyk.app.poplibraries.R
import com.wasilyk.app.poplibraries.model.CountersModel
import com.wasilyk.app.poplibraries.view.MainView

class MainPresenter(private val view: MainView) {
    private val model = CountersModel()

    fun counterClick(id: Int) {
        when(id) {
            R.id.btn_counter1 -> {
                val newValue = model.next(0)
                view.setButtonText(0, "$newValue")
            }
            R.id.btn_counter2 -> {
                val newValue = model.next(1)
                view.setButtonText(1, "$newValue")
            }
            R.id.btn_counter3 -> {
                val newValue = model.next(2)
                view.setButtonText(2, "$newValue")
            }
        }
    }
}