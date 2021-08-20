package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.app.App
import com.wasilyk.app.poplibraries.model.storage.GithubStorageFactory

object CacheUsersDataSourceFactory {
    fun create() : CacheUsersDataSource = CacheUsersDataSourceImpl(GithubStorageFactory.create(App.instance!!.applicationContext))
}