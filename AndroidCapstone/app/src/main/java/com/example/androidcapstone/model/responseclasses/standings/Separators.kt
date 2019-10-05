package com.example.androidcapstone.model.responseclasses.standings

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Separators(

	@field:SerializedName("stage")
	val stage: Int? = null,

	@field:SerializedName("stages")
	val stages: Stages? = null,

	@field:SerializedName("wildcard")
	val wildcard: Int? = null
)