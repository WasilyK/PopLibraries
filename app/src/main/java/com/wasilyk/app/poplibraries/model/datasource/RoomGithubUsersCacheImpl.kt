package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class RoomGithubUsersCacheImpl(private val githubStorage: GithubStorage) : RoomGithubUsersCache {
    override fun fetchUsers(): Single<List<GithubUser>> {
        return githubStorage
            .githubUserDao()
            .fetchUsers()
    }

    override fun fetchUserByLogin(login: String?): Maybe<GithubUser> {
        return githubStorage
            .githubUserDao()
            .fetchUserByLogin(login)
    }

    override fun retain(users: List<GithubUser>): Completable {
        return githubStorage
            .githubUserDao()
            .retain(users)
    }

    override fun retain(user: GithubUser): Completable {
        return githubStorage
            .githubUserDao()
            .retain(user)
    }
}