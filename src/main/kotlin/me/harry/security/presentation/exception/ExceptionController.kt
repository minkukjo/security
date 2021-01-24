package me.harry.security.presentation.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ExceptionController {

    @ExceptionHandler(Throwable::class)
    fun handleException(request: HttpServletRequest, ex: Throwable) {
        println(request)

    }
}