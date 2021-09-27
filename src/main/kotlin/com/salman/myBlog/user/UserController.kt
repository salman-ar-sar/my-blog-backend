package com.salman.myBlog.user

import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping(path = ["api/v1/user"])
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @PostMapping
    fun registerUser(@RequestBody user: User) {
        userService.addUser(user)
    }

    @DeleteMapping(path = ["{userId}"])
    fun deleteUser(@PathVariable("userId") userId: Long) {
        userService.deleteUser(userId)
    }
}