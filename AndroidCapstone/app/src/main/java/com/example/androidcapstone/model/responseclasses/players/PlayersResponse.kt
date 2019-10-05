package com.example.androidcapstone.model.responseclasses.players

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class PlayersResponse(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("last")
	val last: Boolean? = null,

	@field:SerializedName("numberOfElements")
	val numberOfElements: Int? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("totalPages")
	val totalPages: Int? = null,

	@field:SerializedName("sort")
	val sort: Any? = null,

	@field:SerializedName("content")
	val content: List<ContentItem?>? = null,

	@field:SerializedName("first")
	val first: Boolean? = null,

	@field:SerializedName("totalElements")
	val totalElements: Int? = null
)