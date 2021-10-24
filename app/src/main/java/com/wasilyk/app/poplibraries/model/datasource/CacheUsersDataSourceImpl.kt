package com.wasilyk.app.poplibraries.model.datasource

import android.util.Log
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

    override fun retainRepos(userRepos: List<GithubUserRepo>, userId: String):
            Single<List<GithubUserRepo>> {
        userRepos.forEach {
            it.userId = userId
        }
        return roomGithubReposCache
            .insert(userRepos)
            .andThen(getUserRepos(userId))
            .toSingle()
    }

    override fun getUserIdByReposUrl(url: String): String {
        val id = roomGithubUsersCache
            .fetchUserIdByReposUrl(url)
        Log.d("TAG", "id = $id url = $url")
        return id
    }

    override fun getUsers(): Single<List<GithubUser>> =
        roomGithubUsersCache
            .fetchUsers()

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
        roomGithubUsersCache
            .fetchUserByLogin(login)

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> =
        roomGithubReposCache
            .selectRepos(url)
            .toMaybe()
}