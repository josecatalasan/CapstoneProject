package com.example.androidcapstone.model.responseclasses.teams

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("players")
	val players: List<PlayersItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("hasFallback")
	val hasFallback: Boolean? = null,

	@field:SerializedName("logo")
	val logo: Logo? = null,

	@field:SerializedName("handle")
	val handle: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("divisionId")
	val divisionId: Int? = null,

	@field:SerializedName("accounts")
	val accounts: List<AccountsItem?>? = null,

	@field:SerializedName("abbreviatedName")
	val abbreviatedName: String? = null,

	@field:SerializedName("colors")
	val colors: Colors? = null
)