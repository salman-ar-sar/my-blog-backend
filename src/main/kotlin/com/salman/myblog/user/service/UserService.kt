package com.salman.myblog.user.service

import com.salman.myblog.user.dto.UserDTO
import com.salman.myblog.user.dto.UserLoginDTO
import com.salman.myblog.user.dto.UserRequestDTO

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