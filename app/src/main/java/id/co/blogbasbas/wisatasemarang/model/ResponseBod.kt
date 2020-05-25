package id.co.blogbasbas.wisatasemarang.model

import com.google.gson.annotations.SerializedName

data class ResponseBod(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)