package com.salman.myBlog.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping(path = ["api/v1/user"])
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): List<User> {
        return userService.getUsers()
    }
}