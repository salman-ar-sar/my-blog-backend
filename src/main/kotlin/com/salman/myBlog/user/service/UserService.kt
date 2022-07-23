package com.salman.myBlog.user.service

import com.salman.myBlog.user.dto.UserDTO
import com.salman.myBlog.user.dto.UserLoginDTO
import com.salman.myBlog.user.dto.UserRequestDTO

interface UserService {
  fun getUser(userLoginDTO: UserLoginDTO): UserDTO
  fun createUser(userRequestDTO: UserRequestDTO): UserDTO
//  fun deleteUser(userId: Long)
//  fun updateUser(
//    userId: Long,
//    name: String?,
//    email: String?,
//    passwordHash: String?,
//    profilePhoto: String?,
//    followers: Int?
//  )
}