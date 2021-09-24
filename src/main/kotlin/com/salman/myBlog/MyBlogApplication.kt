package com.salman.myBlog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MyBlogApplication

fun main(args: Array<String>) {
	runApplication<MyBlogApplication>(*args)
}
