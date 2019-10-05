package com.example.androidcapstone.model.responseclasses.rankings

import com.google.gson.annotations.SerializedName

data class RankingsResponse(

	@field:SerializedName("playoffCutoff")
	val playoffCutoff: String? = null,

	@field:SerializedName("comparisons")
	val comparisons: List<String?>? = null,

	@field:SerializedName("matchesConcluded")
	val matchesConcluded: Int? = null,

	@field:SerializedName("totalMatches")
	val totalMatches: Int? = null,

	@field:SerializedName("content")
	val content: List<ContentItem?>? = null
)