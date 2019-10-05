package com.example.androidcapstone.model.responseclasses.standings

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DataItem(

	@field:SerializedName("preseason")
	val preseason: Preseason? = null,

	@field:SerializedName("league")
	val league: League? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("stages")
	val stages: Stages? = null,

	@field:SerializedName("logo")
	val logo: Logo? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("divisionId")
	val divisionId: Int? = null,

	@field:SerializedName("abbreviatedName")
	val abbreviatedName: String? = null,

	@field:SerializedName("colors")
	val colors: Colors? = null,

	@field:SerializedName("wildcard")
	val wildcard: Wildcard? = null,

	@field:SerializedName("divLeader")
	val divLeader: DivLeader? = null
)