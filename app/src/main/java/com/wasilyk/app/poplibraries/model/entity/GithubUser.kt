package com.wasilyk.app.poplibraries.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "github_users")
data class GithubUser(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @ColumnInfo(name = "login")
    @SerializedName("login")
    val login: String,

    @ColumnInfo(name = "avatar")
    @SerializedName("avatar_url")
    val avatar: String,

    @ColumnInfo(name = "repos_url")
    @SerializedName("repos_url")
    val repos_url: String
) : Parcelable
