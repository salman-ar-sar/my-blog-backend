package com.salman.myBlog.user

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Month

@Service
class UserService {
    fun getUsers(): List<User> {
        return listOf(
            User(1L,
                "Alan",
                "ala@g.com",
                LocalDate.of(1999, Month.MAY, 20),
                21
            )
        );
    }
}