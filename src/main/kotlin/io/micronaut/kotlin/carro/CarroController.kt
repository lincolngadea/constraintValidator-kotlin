package io.micronaut.kotlin.carro

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller
@Validated
class CarroController {

    @Post("/api/carros")
    fun criar(@Body @Valid carro: Carro, carroRepository: CarroRepository): HttpResponse<Any> {
        val carroSalvo = carroRepository.save(carro)
        return HttpResponse.ok(carroSalvo)
    }
}