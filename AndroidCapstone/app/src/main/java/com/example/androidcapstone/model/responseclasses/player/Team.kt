package com.example.androidcapstone.model.responseclasses.player

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Team(

	@field:SerializedName("addressCountry")
	val addressCountry: String? = null,

	@field:SerializedName("@etag")
	val etag: String? = null,

	@field:SerializedName("game")
	val game: String? = null,

	@field:SerializedName("availableLanguages")
	val availableLanguages: List<String?>? = null,

	@field:SerializedName("attributesVersion")
	val attributesVersion: String? = null,

	@field:SerializedName("primaryColor")
	val primaryColor: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("handle")
	val handle: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("divisions")
	val divisions: List<DivisionsItem?>? = null,

	@field:SerializedName("homeLocation")
	val homeLocation: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("secondaryPhoto")
	val secondaryPhoto: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("accounts")
	val accounts: List<AccountsItem?>? = null,

	@field:SerializedName("abbreviatedName")
	val abbreviatedName: String? = null,

	@field:SerializedName("secondaryColor")
	val secondaryColor: String? = null
)