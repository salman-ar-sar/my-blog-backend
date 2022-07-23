package com.salman.myBlog.user.service

import com.salman.myBlog.user.db.UserEntity
import com.salman.myBlog.user.dto.UserDTO
import com.salman.myBlog.user.dto.UserLoginDTO
import com.salman.myBlog.user.dto.UserRequestDTO
import com.salman.myBlog.user.helpers.UserServiceHelper
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserServiceImpl(private val helper: UserServiceHelper) : UserService {
  override fun getUser(userLoginDTO: UserLoginDTO): UserDTO {
    with(helper) {
      val user = findUserByEmail(userLoginDTO.email)
      val wrongPassword = user?.passwordHash != userLoginDTO.passwordHash
      if (user == null || wrongPassword)
        throw IllegalStateException("User credentials not correct!")

      return UserDTO(
        id = user.id,
        name = user.name,
        email = user.email,
        profilePhoto = user.profilePhoto,
        age = user.age,
        followers = user.followers,
      )
    }
  }

  override fun createUser(userRequestDTO: UserRequestDTO): UserDTO {
    with(helper) {
      val userByEmail = findUserByEmail(userRequestDTO.email)
      if (userByEmail != null) {
        throw IllegalStateException("Email taken!")
      }
      val user = saveUser(
        UserEntity(
          name = userRequestDTO.name,
          email = userRequestDTO.email,
          passwordHash = userRequestDTO.passwordHash,
          profilePhoto = userRequestDTO.profilePhoto,
          dob = userRequestDTO.dob,
          followers = 0,
        )
      )

      return UserDTO(
        id = user.id,
        name = user.name,
        email = user.email,
        age = user.age,
        profilePhoto = user.profilePhoto,
        followers = user.followers,
      )
    }
  }

//  override fun deleteUser(userId: Long) {
//    val exists = userRepository.existsById(userId)
//    if (!exists) {
//      throw IllegalStateException("User with ID:$userId doesn't exits")
//    }
//    userRepository.deleteById(userId)
//  }
//
//  @Transactional
//  override fun updateUser(
//    userId: Long,
//    name: String?,
//    email: String?,
//    passwordHash: String?,
//    profilePhoto: String?,
//    followers: Int?
//  ) {
//    val user = userRepository.findById(userId)
//      .orElseThrow { IllegalStateException("User with ID:$userId doesn't exits") }
//
//    if (name != null && name.isNotEmpty() && name != user.name) {
//      user.name = name
//    }
//
//    if (email != null && email.isNotEmpty() && email != user.email) {
//      val userByEmail = userRepository.findUserByEmail(email)
//      if (userByEmail.isPresent) {
//        throw IllegalStateException("Email taken!")
//      }
//
//      user.email = email
//    }
//    if (passwordHash != null && passwordHash.isNotEmpty() && passwordHash != user.passwordHash) {
//      user.passwordHash = passwordHash
//    }
//    if (profilePhoto != null && profilePhoto.isNotEmpty() && profilePhoto != user.profilePhoto) {
//      user.profilePhoto = profilePhoto
//    }
//    if (followers != null && followers != user.followers) {
//      user.followers = followers
//    }
//  }
}