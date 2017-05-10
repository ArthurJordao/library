package io.github.arthurjordao

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {
    SpringApplication.run(LibraryApplication::class.java, *args)
}
