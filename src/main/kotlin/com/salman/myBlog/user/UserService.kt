package com.salman.myBlog.user

import org.springframework.stereotype.Service
import javax.transaction.Transactional

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

    @Transactional
    fun updateUser(userId: Long, name: String?, email: String?) {
        val user = userRepository.findById(userId)
            .orElseThrow { IllegalStateException("User with ID:$userId doesn't exits") }

        if (name != null && name.isNotEmpty() && name != user.name) {
            user.name = name
        }

        if (email != null && email.isNotEmpty() && email != user.email) {
            val userByEmail = userRepository.findUserByEmail(email)
            if (userByEmail.isPresent) {
                throw IllegalStateException("Email taken!")
            }

            user.email = email
        }


    }
}