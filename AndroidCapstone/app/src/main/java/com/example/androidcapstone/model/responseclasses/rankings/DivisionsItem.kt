package com.example.androidcapstone.model.responseclasses.rankings

import com.google.gson.annotations.SerializedName

data class DivisionsItem(

	@field:SerializedName("division")
	val division: Division? = null,

	@field:SerializedName("competitor")
	val competitor: Competitor? = null
)