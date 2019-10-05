package com.example.androidcapstone.model.responseclasses.rankings

import com.google.gson.annotations.SerializedName

data class ContentItem(

	@field:SerializedName("records")
	val records: List<RecordsItem?>? = null,

	@field:SerializedName("competitor")
	val competitor: Competitor? = null,

	@field:SerializedName("advantage")
	val advantage: Int? = null,

	@field:SerializedName("placement")
	val placement: Int? = null
)