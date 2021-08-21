package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.app.App
import com.wasilyk.app.poplibraries.model.storage.GithubStorageFactory

object RoomGithubReposCacheFactory {
    fun create(): RoomGithubReposCache = RoomGithubReposCacheImpl(
        GithubStorageFactory.create(App.instance!!.applicationContext)
    )
}