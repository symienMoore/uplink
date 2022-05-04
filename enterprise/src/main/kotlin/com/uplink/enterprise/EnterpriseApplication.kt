package com.uplink.enterprise

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class EnterpriseApplication

fun main(args: Array<String>) {
	runApplication<EnterpriseApplication>(*args)
}
