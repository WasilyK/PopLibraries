package com.wasilyk.app.poplibraries.model.api

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GithubApi {

    @GET("/users")
    fun getUsers(@Query("since") since: Int? = null): Single<List<GithubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<GithubUser>

    @GET
    fun getUserRepos(@Url url: String): Single<List<GithubUserRepo>>
}