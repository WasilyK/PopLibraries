package com.wasilyk.app.poplibraries.model.storage

import android.content.Context
import androidx.room.Room

object GithubStorageFactory {
    fun create(context: Context): GithubStorage =
        Room.databaseBuilder(context, GithubStorage::class.java, "github.db")
//            .fallbackToDestructiveMigration()
            .build()
}
