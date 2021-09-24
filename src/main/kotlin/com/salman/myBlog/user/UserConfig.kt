package com.salman.myBlog.user

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month.*

@Configuration
class UserConfig {

    @Bean
    fun commandLineRunner(userRepository: UserRepository)= CommandLineRunner {
        val alan = User(1L,"Alan","alan@gmail.com", LocalDate.of(2004, MAY, 10), 21)
        val alex = User(2L, "Alex","alex@gmail.com", LocalDate.of(1974, MAY, 10), 41)
        val anil = User(3L,"Anil","anil@gmail.com",LocalDate.of(2000, MAY, 10), 25)

        userRepository.saveAll(listOf(alan, alex, anil))
    }

}