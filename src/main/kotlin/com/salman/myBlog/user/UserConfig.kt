package com.salman.myBlog.user

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.Month.*

@Component
class UserConfig {

    @Bean
    fun commandLineRunner(userRepository: UserRepository)= CommandLineRunner {
        val alan = User(1L,"Alan","alan@gmail.com", LocalDate.of(2004, MAY, 10))
        val alex = User(2L, "Alex","alex@gmail.com", LocalDate.of(1974, AUGUST, 10))
        val anil = User(3L,"Anil","anil@gmail.com",LocalDate.of(2000, MAY, 10))

        userRepository.saveAll(listOf(alan, alex, anil))
    }

}