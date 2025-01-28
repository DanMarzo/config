package br.com.marzo.greeting_service.controllers

import br.com.marzo.greeting_service.model.Greeting
import br.com.marzo.greeting_service.model.GreetingConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    //parecido com o utilizado no flutter
    @Autowired
    private lateinit var configuration: GreetingConfiguration

    val counter = AtomicLong();

    @GetMapping("/")
    fun greeting(@RequestParam(name = "nome", required = false) nome: String?): ResponseEntity<Greeting> {
        val greeting = Greeting(counter.incrementAndGet())
        greeting.nome = if (ObjectUtils.isEmpty(nome)) this.configuration.greeting.toString() else nome.toString()

        return ResponseEntity(greeting, HttpStatus.OK);
    }
}