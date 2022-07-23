package com.salman.myBlog.user.helpers

import com.salman.myBlog.user.db.UserEntity
import com.salman.myBlog.user.db.UserRepository
import org.springframework.stereotype.Component

@Component
class UserServiceHelper(val userRepository: UserRepository) {
  internal fun saveUser(user: UserEntity) = userRepository.save(user)

  internal fun findUserByEmail(email: String) = userRepository.findUserByEmail(email)
}