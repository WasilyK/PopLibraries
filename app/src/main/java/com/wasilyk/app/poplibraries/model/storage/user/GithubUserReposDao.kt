package com.wasilyk.app.poplibraries.model.storage.user

import androidx.room.*
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface GithubUserReposDao {
    @Query("SELECT * FROM github_user_repos")
    fun selectRepos(): Single<List<GithubUserRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(repos: List<GithubUserRepo>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(repo: GithubUserRepo): Completable
}