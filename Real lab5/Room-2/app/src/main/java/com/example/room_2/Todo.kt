package com.example.room_2

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("completed")
    val completed: Boolean?
): Parcelable{
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readBoolean()
    ) {
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        if (id != null) {
            parcel.writeInt(id)
        }
        if (userId != null) {
            parcel.writeInt(userId)
        }
        parcel.writeString(title)
        if (completed != null) {
            parcel.writeBoolean(completed)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }

    }
}