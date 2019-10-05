package com.example.androidcapstone.model.responseclasses.players

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ContentItem(

	@field:SerializedName("@etag")
	val etag: String? = null,

	@field:SerializedName("game")
	val game: String? = null,

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null,

	@field:SerializedName("availableLanguages")
	val availableLanguages: List<String?>? = null,

	@field:SerializedName("attributesVersion")
	val attributesVersion: String? = null,

	@field:SerializedName("givenName")
	val givenName: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("headshot")
	val headshot: String? = null,

	@field:SerializedName("homeLocation")
	val homeLocation: String? = null,

	@field:SerializedName("familyName")
	val familyName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("accounts")
	val accounts: List<AccountsItem?>? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("handle")
	val handle: String? = null
)