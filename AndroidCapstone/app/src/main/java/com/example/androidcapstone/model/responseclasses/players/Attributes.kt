package com.example.androidcapstone.model.responseclasses.players

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Attributes(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("heroes")
	val heroes: List<String?>? = null,

	@field:SerializedName("player_number")
	val playerNumber: Int? = null,

	@field:SerializedName("preferred_slot")
	val preferredSlot: String? = null,

	@field:SerializedName("hero_image")
	val heroImage: Any? = null,

	@field:SerializedName("manager")
	val manager: Any? = null,

	@field:SerializedName("city")
	val city: Any? = null,

	@field:SerializedName("team_guid")
	val teamGuid: String? = null
)