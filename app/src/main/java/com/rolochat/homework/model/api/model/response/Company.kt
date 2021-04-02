package com.rolochat.homework.model.api.model.response


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,
    @ColumnInfo
    @SerializedName("bs")
    val bs: String,
    @ColumnInfo
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @ColumnInfo
    @SerializedName("name")
    val name: String
): Parcelable