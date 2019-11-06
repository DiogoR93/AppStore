package com.domain.drapps.appstore.shared.repositories.server.responseobject

import com.google.gson.annotations.SerializedName

data class AppListResponse (
    @SerializedName("responses") var responses : Response
)

data class Response (
    @SerializedName("listApps") var listApps : ListApps
)

data class ListApps (
    @SerializedName("info") val info : Info,
    @SerializedName("datasets") val datasets : Datasets
)

data class Datasets (

    @SerializedName("all") val all : All
)

data class All (
    @SerializedName("data") val data : Data
)

data class Data (
    @SerializedName("list") val list : List<AppObjectFromServer>
)

data class AppObjectFromServer (
    // missing app tags TODO
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("package") val packagee : String,
    @SerializedName("store_id") val store_id : String,
    @SerializedName("store_name") val store_name : String,
    @SerializedName("vername") val vername : String,
    @SerializedName("vercode") val vercode : String,
    @SerializedName("md5sum") val md5sum : String,
    @SerializedName("size") val size : String,
    @SerializedName("downloads") val downloads : String,
    @SerializedName("pdownloads") val pdownloads : String,
    @SerializedName("added") val added : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("updated") val updated : String,
    @SerializedName("rating") val rating : String,
    @SerializedName("icon") val icon : String,
    @SerializedName("graphic") val graphic : String?,
    @SerializedName("uptype") val uptype : String
)

data class Info (

    @SerializedName("status") val status : String
)
