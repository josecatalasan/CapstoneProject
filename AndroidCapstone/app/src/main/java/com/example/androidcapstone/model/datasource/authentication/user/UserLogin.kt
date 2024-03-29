package com.example.androidcapstone.model.datasource.authentication.user

import android.os.Parcel
import android.os.Parcelable

data class UserLogin(var email: String, var password: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserLogin> {
        override fun createFromParcel(parcel: Parcel): UserLogin {
            return UserLogin(parcel)
        }

        override fun newArray(size: Int): Array<UserLogin?> {
            return arrayOfNulls(size)
        }
    }
}