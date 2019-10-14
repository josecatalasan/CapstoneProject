package com.example.androidcapstone.model.responseclasses.teams

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PlayersItem(

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("headshot")
	val headshot: String? = null,

	@field:SerializedName("homeLocation")
	val homeLocation: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("flags")
	val flags: List<Any?>? = null,

	@field:SerializedName("fullName")
	val fullName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("accounts")
	val accounts: List<AccountsItem?>? = null,

	@field:SerializedName("handle")
	val handle: String? = null
) : Parcelable {

	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		null,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		null,
		parcel.readString()
	)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(number)
		parcel.writeString(role)
		parcel.writeString(headshot)
		parcel.writeString(homeLocation)
		parcel.writeString(name)
		parcel.writeString(fullName)
		parcel.writeValue(id)
		parcel.writeString(handle)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<PlayersItem> {
		override fun createFromParcel(parcel: Parcel): PlayersItem {
			return PlayersItem(parcel)
		}

		override fun newArray(size: Int): Array<PlayersItem?> {
			return arrayOfNulls(size)
		}
	}
}