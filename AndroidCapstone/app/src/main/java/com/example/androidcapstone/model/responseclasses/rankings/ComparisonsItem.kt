package com.example.androidcapstone.model.responseclasses.rankings

import com.google.gson.annotations.SerializedName

data class ComparisonsItem(

	@field:SerializedName("value")
	val value: Double? = null,

	@field:SerializedName("key")
	val key: String? = null
)