package com.salman.myBlog.user

import org.springframework.web.bind.annotation.*

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

    @PutMapping(path = ["{userId}"])
    fun updateUser(
            @PathVariable("userId") userId: Long,
            @RequestParam(required = false) name: String?,
            @RequestParam(required = false) passwordHash: String?,
            @RequestParam(required = false) profilePhoto: String?,
            @RequestParam(required = false) followers: Int?,
            @RequestParam(required = false) email: String?) {
        userService.updateUser(userId, name, email, passwordHash, profilePhoto, followers)
    }
}