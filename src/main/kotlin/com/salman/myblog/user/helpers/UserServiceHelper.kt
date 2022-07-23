package com.salman.myblog.user.helpers

import com.salman.myblog.user.db.UserEntity
import com.salman.myblog.user.db.UserRepository
import org.springframework.stereotype.Component

@Component
class UserServiceHelper(val userRepository: UserRepository) {
  internal fun saveUser(user: UserEntity) = userRepository.save(user)

  internal fun findUserByEmail(email: String) = userRepository.findUserByEmail(email)
}