package com.salman.myblog

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class MyBlogApplication

fun main(args: Array<String>) {
	runApplication<MyBlogApplication>(*args)
}
