package com.example.androidcapstone.model.responseclasses.rankings

import com.google.gson.annotations.SerializedName

data class RecordsItem(

	@field:SerializedName("gamePointsAgainst")
	val gamePointsAgainst: Int? = null,

	@field:SerializedName("matchWin")
	val matchWin: Int? = null,

	@field:SerializedName("gamePointsFor")
	val gamePointsFor: Int? = null,

	@field:SerializedName("comparisons")
	val comparisons: List<ComparisonsItem?>? = null,

	@field:SerializedName("gameTie")
	val gameTie: Int? = null,

	@field:SerializedName("matchDraw")
	val matchDraw: Int? = null,

	@field:SerializedName("matchBye")
	val matchBye: Int? = null,

	@field:SerializedName("gameLoss")
	val gameLoss: Int? = null,

	@field:SerializedName("matchLoss")
	val matchLoss: Int? = null,

	@field:SerializedName("gameWin")
	val gameWin: Int? = null
)