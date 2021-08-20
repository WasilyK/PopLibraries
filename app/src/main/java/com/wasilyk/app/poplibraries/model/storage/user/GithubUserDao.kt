package com.wasilyk.app.poplibraries.model.storage.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

@Dao
interface GithubUserDao {
    @Query("SELECT * FROM github_users")
    fun fetchUsers(): Single<List<GithubUser>>

    @Query("SELECT * FROM github_users WHERE login LIKE :login LIMIT 1")
    fun fetchUserByLogin(login: String?): Maybe<GithubUser>

    @Insert(onConflict = REPLACE)
    fun retain(users: List<GithubUser>): Completable

    @Update(onConflict = REPLACE)
    fun retain(user: GithubUser): Completable
}
