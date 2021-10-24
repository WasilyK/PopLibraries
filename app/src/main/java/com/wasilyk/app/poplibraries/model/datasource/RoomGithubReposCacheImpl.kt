package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class RoomGithubReposCacheImpl(
    private val storage: GithubStorage
): RoomGithubReposCache {
    override fun selectRepos(userId: String): Single<List<GithubUserRepo>> =
        storage
            .githubUserReposDao()
            .selectRepos(userId)

    override fun insert(repos: List<GithubUserRepo>): Completable {
        return storage
            .githubUserReposDao()
            .insert(repos)
    }

    override fun update(repo: GithubUserRepo): Completable =
        storage
            .githubUserReposDao()
            .update(repo)
}