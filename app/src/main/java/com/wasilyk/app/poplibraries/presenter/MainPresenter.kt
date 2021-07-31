package com.wasilyk.app.poplibraries.presenter

import com.wasilyk.app.poplibraries.model.CountersModel
import com.wasilyk.app.poplibraries.view.MainView

class MainPresenter(private val view: MainView) {
    private val model = CountersModel()

    fun counterButton1Click() = view.setButton1Text("${model.next(0)}")
    fun counterButton2Click() = view.setButton2Text("${model.next(1)}")
    fun counterButton3Click() = view.setButton3Text("${model.next(2)}")
}