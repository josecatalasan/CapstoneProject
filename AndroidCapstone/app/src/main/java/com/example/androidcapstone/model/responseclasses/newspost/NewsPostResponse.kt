package com.example.androidcapstone.model.responseclasses.newspost

import com.google.gson.annotations.SerializedName

data class NewsPostResponse(

	@field:SerializedName("featuredMap")
	val featuredMap: Boolean? = null,

	@field:SerializedName("commentsEnabled")
	val commentsEnabled: Boolean? = null,

	@field:SerializedName("customPublish")
	val customPublish: Boolean? = null,

	@field:SerializedName("keywords")
	val keywords: List<String?>? = null,

	@field:SerializedName("stickyForThisLocale")
	val stickyForThisLocale: Boolean? = null,

	@field:SerializedName("showPtr")
	val showPtr: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("defaultCommunity")
	val defaultCommunity: String? = null,

	@field:SerializedName("commentKey")
	val commentKey: String? = null,

	@field:SerializedName("draft")
	val draft: Boolean? = null,

	@field:SerializedName("showRating")
	val showRating: Boolean? = null,

	@field:SerializedName("siteCategory")
	val siteCategory: String? = null,

	@field:SerializedName("defaultUrl")
	val defaultUrl: String? = null,

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: Thumbnail? = null,

	@field:SerializedName("created")
	val created: Long? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("communityBlogs")
	val communityBlogs: List<CommunityBlogsItem?>? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("pollAttached")
	val pollAttached: Boolean? = null,

	@field:SerializedName("localizationPublish")
	val localizationPublish: Long? = null,

	@field:SerializedName("publish")
	val publish: Long? = null,

	@field:SerializedName("blogId")
	val blogId: Int? = null,

	@field:SerializedName("updated")
	val updated: Long? = null,

	@field:SerializedName("spotlight")
	val spotlight: Boolean? = null,

	@field:SerializedName("status")
	val status: String? = null
)