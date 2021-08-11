package com.wasilyk.app.poplibraries.model.datasource

object CacheUsersDataSourceFactory {
    fun create() : CacheUsersDataSource = CacheUsersDataSourceImpl()
}