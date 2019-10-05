package com.example.androidcapstone.model.responseclasses.players

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DivisionsItem(

	@field:SerializedName("division")
	val division: Division? = null,

	@field:SerializedName("competitor")
	val competitor: Competitor? = null
)