package com.salman.myblog.user.dto

data class UserLoginDTO(
  var email: String,
  var passwordHash: String,
)
