package com.example.androidcapstone.model.responseclasses.players

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class TeamsItem(

	@field:SerializedName("flags")
	val flags: List<Any?>? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("player")
	val player: Player? = null
)