package com.example.androidcapstone.model.responseclasses.streamstatus

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class StreamStatusResponse(

	@field:SerializedName("embedUrl")
	val embedUrl: String? = null,

	@field:SerializedName("streamType")
	val streamType: Any? = null,

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("interactiveEmbed")
	val interactiveEmbed: String? = null,

	@field:SerializedName("platform")
	val platform: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)