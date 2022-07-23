package com.salman.myblog.user.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class UserRequestDTO (
  var name: String,
  var email: String,
  var passwordHash: String,
  var profilePhoto: String,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  var dob: LocalDate
)