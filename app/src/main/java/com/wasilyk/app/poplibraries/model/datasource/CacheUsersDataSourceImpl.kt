package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class CacheUsersDataSourceImpl(
    private val roomGithubUsersCache: RoomGithubUsersCache,
    private val roomGithubReposCache: RoomGithubReposCache
) : CacheUsersDataSource {

    override fun retain(users: List<GithubUser>): Single<List<GithubUser>> =
        roomGithubUsersCache
            .retain(users)
            .andThen(getUsers())

    override fun retain(user: GithubUser): Single<GithubUser> =
        roomGithubUsersCache
            .retain(user)
            .andThen(getUserByLogin(user.login))
            .toSingle()

    override fun retainRepos(userRepos: List<GithubUserRepo>) {
        roomGithubReposCache
            .retain(userRepos)
    }

    override fun getUsers(): Single<List<GithubUser>> =
        roomGithubUsersCache
            .fetchUsers()

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
        roomGithubUsersCache
            .fetchUserByLogin(login)

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> =
        roomGithubReposCache
            .selectRepos()
            .toMaybe()
}