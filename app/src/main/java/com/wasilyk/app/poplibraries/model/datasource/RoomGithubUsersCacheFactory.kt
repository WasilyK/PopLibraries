package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.app.App
import com.wasilyk.app.poplibraries.model.storage.GithubStorageFactory

object RoomGithubUsersCacheFactory {
    fun create(): RoomGithubUsersCache = RoomGithubUsersCacheImpl(
        GithubStorageFactory.create(App.instance!!.applicationContext))
}