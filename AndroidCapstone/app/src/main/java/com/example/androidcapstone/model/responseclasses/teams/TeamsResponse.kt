package com.example.androidcapstone.model.responseclasses.teams

import com.google.gson.annotations.SerializedName

data class TeamsResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)