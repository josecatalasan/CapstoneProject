package com.example.androidcapstone.model.responseclasses.teams

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Colors(

	@field:SerializedName("secondary")
	val secondary: Secondary? = null,

	@field:SerializedName("tertiary")
	val tertiary: Tertiary? = null,

	@field:SerializedName("primary")
	val primary: Primary? = null
)