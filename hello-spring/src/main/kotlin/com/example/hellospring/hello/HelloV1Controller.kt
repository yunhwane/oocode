package com.example.hellospring.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/hello")
class HelloV1Controller {

    @GetMapping
    fun hello(): String {
        return "Hello, Spring v1!"
    }
}