package com.example.androidcapstone.model.responseclasses.teams

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
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
)