package com.wasilyk.app.poplibraries.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.storage.user.GithubUserDao

@Database(exportSchema = false, entities = [GithubUser::class], version = 1)
abstract class GithubStorage: RoomDatabase() {
    abstract fun githubUserDao(): GithubUserDao
}
