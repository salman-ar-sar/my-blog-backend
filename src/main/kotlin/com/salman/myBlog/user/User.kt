package com.salman.myBlog.user

import java.time.LocalDate

data class User(var id: Long,
                var name: String,
                var email: String,
                var dob: LocalDate,
                var age: Int)