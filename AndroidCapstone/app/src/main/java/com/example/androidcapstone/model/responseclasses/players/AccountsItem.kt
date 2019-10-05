package com.example.androidcapstone.model.responseclasses.players

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AccountsItem(

	@field:SerializedName("accountType")
	val accountType: String? = null,

	@field:SerializedName("competitorId")
	val competitorId: Int? = null,

	@field:SerializedName("isPublic")
	val isPublic: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("value")
	val value: String? = null
)