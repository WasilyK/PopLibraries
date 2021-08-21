package com.wasilyk.app.poplibraries.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "github_user_repos")
data class GithubUserRepo(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @PrimaryKey
    @ColumnInfo(name = "url")
    @SerializedName("url")
    val url: String,

    @ColumnInfo(name = "forks_count")
    @SerializedName("forks_count")
    val forkCount: Int = 0
) : Parcelable
