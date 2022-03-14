package com.example.warbird

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WarbirdApplication

fun main(args: Array<String>) {
    runApplication<WarbirdApplication>(*args)
}
