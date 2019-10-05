package com.example.androidcapstone.model.responseclasses.newsposts

import com.google.gson.annotations.SerializedName

data class CommunityBlogsItem(

	@field:SerializedName("defaulted")
	val defaulted: Boolean? = null,

	@field:SerializedName("sticky")
	val sticky: Boolean? = null,

	@field:SerializedName("communityId")
	val communityId: Int? = null
)