package com.example.gradledemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class GradleDemoApplication

fun main(args: Array<String>) {
    runApplication<GradleDemoApplication>(*args)
}
