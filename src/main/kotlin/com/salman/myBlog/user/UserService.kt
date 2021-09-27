package com.salman.myBlog.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUsers(): List<User> {
        return userRepository.findAll();
    }

    fun addUser(user: User) {
        println(user)
    }
}