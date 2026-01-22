package playground.api.web.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import playground.api.application.exception.MessageNotFoundByIdException
import playground.api.application.exception.NoMessageException
import java.net.URI

@ControllerAdvice
class GlobalExceptionHandler{

    @ExceptionHandler(MessageNotFoundByIdException::class)
    fun handleProjectionNotFoundException(ex: MessageNotFoundByIdException, request: HttpServletRequest): ProblemDetail {
        val problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.message)
        problem.title = "Not Found"
        problem.type = URI.create("https://example.com/errors/not-found")
        problem.instance = URI.create(request.requestURI)
        return problem
    }

    @ExceptionHandler(NoMessageException::class)
    fun handleProjectionNotFoundException(ex: NoMessageException, request: HttpServletRequest): ProblemDetail {
        val problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.message)
        problem.title = "Not Found"
        problem.type = URI.create("https://example.com/errors/not-found")
        problem.instance = URI.create(request.requestURI)
        return problem
    }

    @ExceptionHandler(Exception::class)
    fun handleAll(ex: Exception, request: HttpServletRequest): ProblemDetail {
        val problem =
            ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.message ?: "Internal Server Error")
        problem.title = "Internal Server Error"
        problem.type = URI.create("https://example.com/errors/internal-server-error")
        problem.instance = URI.create(request.requestURI)
        return problem
    }
}