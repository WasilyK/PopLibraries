package com.wasilyk.app.poplibraries.model.repo

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6"),
        GithubUser("login7")
    )

    fun getUsers(): Single<List<GithubUser>> = Single.just(repositories)
}