package com.salman.myBlog.user.dto

data class UserLoginDTO(
  var email: String,
  var passwordHash: String,
)
