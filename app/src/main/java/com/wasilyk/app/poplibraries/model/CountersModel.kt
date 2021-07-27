package com.wasilyk.app.poplibraries.model

class CountersModel {
    private val counters = mutableListOf(0,0,0)

    fun getCurrent(index: Int) = counters[index]
    fun next(index: Int) = ++counters[index]
    fun set(index: Int, value: Int) { counters[index] = value }
}