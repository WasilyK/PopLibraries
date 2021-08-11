package com.wasilyk.app.poplibraries.view

interface UserItemView: IItemView {
    fun setUser(login: String, avatar_url: String)
}