package com.wasilyk.app.poplibraries.presenter

import com.wasilyk.app.poplibraries.view.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}