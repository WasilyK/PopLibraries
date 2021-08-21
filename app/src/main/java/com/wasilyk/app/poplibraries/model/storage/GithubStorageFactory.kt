package com.wasilyk.app.poplibraries.model.storage

import android.content.Context
import androidx.room.Room

object GithubStorageFactory {
    private var storage: GithubStorage? = null
    fun create(context: Context): GithubStorage {
        if(storage == null) {
            storage = Room.databaseBuilder(context, GithubStorage::class.java, "github.db")
//            .fallbackToDestructiveMigration()
                .build()
        }
        return storage!!
    }
}
