package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface UsersDataSource {

    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String?): Maybe<GithubUser>
    fun getUserRepos(url: String): Maybe<List<GithubUserRepo>>

}