package com.salman.myBlog.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUsers(): List<User> {
        return userRepository.findAll();
    }

    fun addUser(user: User) {
        val userByEmail = userRepository.findUserByEmail(user.email)
        if (userByEmail.isPresent) {
            throw IllegalStateException("Email taken!")
        }
        userRepository.save(user)
    }

    fun deleteUser(userId: Long) {
        val exists: Boolean = userRepository.existsById(userId)
        if (!exists) {
            throw IllegalStateException("User with ID:$userId doesn't exits")
        }
        userRepository.deleteById(userId)
    }
}