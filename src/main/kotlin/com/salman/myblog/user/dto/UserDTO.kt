package com.salman.myblog.user.dto

data class UserDTO(
  var id: Long,
  var name: String,
  var email: String,
  var profilePhoto: String,
  var followers: Int,
  val age: Int
)