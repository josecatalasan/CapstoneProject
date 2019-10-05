package com.example.androidcapstone.model.responseclasses.standings

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Meta(

	@field:SerializedName("strings")
	val strings: Strings? = null,

	@field:SerializedName("separators")
	val separators: Separators? = null,

	@field:SerializedName("divisions")
	val divisions: List<DivisionsItem?>? = null
)