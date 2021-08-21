package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class RoomGithubReposCacheImpl(
    private val storage: GithubStorage
): RoomGithubReposCache {
    override fun selectRepos(): Single<List<GithubUserRepo>> =
        storage
            .githubUserReposDao()
            .selectRepos()

    override fun retain(repos: List<GithubUserRepo>): Completable {
        return storage
            .githubUserReposDao()
            .retain(repos)
    }
    override fun update(repo: GithubUserRepo): Completable =
        storage
            .githubUserReposDao()
            .update(repo)
}