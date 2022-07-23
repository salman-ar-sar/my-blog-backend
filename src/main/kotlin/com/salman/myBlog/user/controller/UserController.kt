package com.salman.myBlog.user.controller

import com.salman.myBlog.user.dto.UserDTO
import com.salman.myBlog.user.dto.UserLoginDTO
import com.salman.myBlog.user.dto.UserRequestDTO
import com.salman.myBlog.user.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1"])
class UserController(private val userService: UserService) {

    @PostMapping("/login")
    fun getUsers(@RequestBody userLoginDTO: UserLoginDTO): UserDTO {
        return userService.getUser(userLoginDTO)
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody userRequestDTO: UserRequestDTO): UserDTO {
        return userService.createUser(userRequestDTO)
    }

//    @DeleteMapping(path = ["{userId}"])
//    fun deleteUser(@PathVariable("userId") userId: Long) {
//        userService.deleteUser(userId)
//    }
//
//    @PutMapping(path = ["{userId}"])
//    fun updateUser(
//            @PathVariable("userId") userId: Long,
//            @RequestParam(required = false) name: String?,
//            @RequestParam(required = false) passwordHash: String?,
//            @RequestParam(required = false) profilePhoto: String?,
//            @RequestParam(required = false) followers: Int?,
//            @RequestParam(required = false) email: String?) {
//        userService.updateUser(userId, name, email, passwordHash, profilePhoto, followers)
//    }
}