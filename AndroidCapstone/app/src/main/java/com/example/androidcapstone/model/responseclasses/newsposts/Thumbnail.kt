package com.example.androidcapstone.model.responseclasses.newsposts

import com.google.gson.annotations.SerializedName

data class Thumbnail(

	@field:SerializedName("originalFileName")
	val originalFileName: String? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("mediaType")
	val mediaType: Int? = null,

	@field:SerializedName("mimeType")
	val mimeType: String? = null,

	@field:SerializedName("mediaId")
	val mediaId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)