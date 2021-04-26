package io.micronaut.kotlin.carro

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CarroRepository: JpaRepository<Carro, Long> {

    fun existsByPlaca(placa: String): Boolean
}