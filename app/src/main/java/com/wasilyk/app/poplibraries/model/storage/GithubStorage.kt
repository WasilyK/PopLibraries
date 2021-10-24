package com.wasilyk.app.poplibraries.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import com.wasilyk.app.poplibraries.model.storage.user.GithubUserDao
import com.wasilyk.app.poplibraries.model.storage.user.GithubUserReposDao

@Database(exportSchema = false, entities = [GithubUser::class, GithubUserRepo::class], version = 1)
abstract class GithubStorage: RoomDatabase() {
    abstract fun githubUserDao(): GithubUserDao
    abstract fun githubUserReposDao(): GithubUserReposDao
}
