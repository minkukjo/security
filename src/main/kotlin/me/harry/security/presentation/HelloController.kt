package me.harry.security.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun sayHello(name: String?): String {
        return "Hello $name"
    }

    @GetMapping("/admin/hello")
    fun sayAdminHello(name: String?): String {
        return "Hello Admin $name"
    }

}