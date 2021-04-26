package io.micronaut.kotlin.carro

import io.micronaut.core.annotation.Introspected
import javax.persistence.*
import javax.persistence.GenerationType.*
import javax.validation.constraints.NotBlank

@Introspected
@Entity
data class Carro(

    @field:NotBlank
    @Column(nullable = false)
    val modelo: String?,

    @field:NotBlank
    @field:Placa
    @Column(nullable = false, unique = true)
    val placa: String?
){
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
}