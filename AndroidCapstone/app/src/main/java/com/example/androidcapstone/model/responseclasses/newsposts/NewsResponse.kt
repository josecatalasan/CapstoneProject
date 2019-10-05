package com.example.androidcapstone.model.responseclasses.newsposts

import com.google.gson.annotations.SerializedName

data class NewsResponse(

	@field:SerializedName("totalBlogs")
	val totalBlogs: Int? = null,

	@field:SerializedName("blogs")
	val blogs: List<BlogsItem?>? = null,

	@field:SerializedName("totalPages")
	val totalPages: Int? = null,

	@field:SerializedName("pageSize")
	val pageSize: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null
)