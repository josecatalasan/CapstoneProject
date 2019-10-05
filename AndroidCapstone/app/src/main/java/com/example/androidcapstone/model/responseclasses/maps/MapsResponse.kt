package com.example.androidcapstone.model.responseclasses.maps

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class MapsResponse(

	@field:SerializedName("gameModes")
	val gameModes: List<GameModesItem?>? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("name")
	val name: Name? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("guid")
	val guid: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)