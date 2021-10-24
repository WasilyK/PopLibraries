package com.wasilyk.app.poplibraries.di.modules

import com.wasilyk.app.poplibraries.model.api.GithubApi
import com.wasilyk.app.poplibraries.model.datasource.*
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import dagger.Module
import dagger.Provides

@Module
class DatasourceModule {

    @Provides
    fun provideCacheUsersDataSource(
        roomGithubUsersCache: RoomGithubUsersCache,
        roomGithubReposCache: RoomGithubReposCache
    ): CacheUsersDataSource = CacheUsersDataSourceImpl(roomGithubUsersCache, roomGithubReposCache)

    @Provides
    fun provideRoomGithubReposCache(githubStorage: GithubStorage): RoomGithubReposCache =
        RoomGithubReposCacheImpl(githubStorage)

    @Provides
    fun provideRoomGithubUsersCache(githubStorage: GithubStorage): RoomGithubUsersCache =
        RoomGithubUsersCacheImpl(githubStorage)

    @Provides
    fun provideUsersDataSource(githubApi: GithubApi): UsersDataSource =
        UsersDataSourceImpl(githubApi)
}