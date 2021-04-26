package io.micronaut.kotlin
import io.micronaut.kotlin.carro.Carro
import io.micronaut.kotlin.carro.CarroRepository
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(
    rollback = false,
    transactionMode = TransactionMode.SINGLE_TRANSACTION,
    transactional = false
)
class CarrosGrpcTest {

    @Inject
    lateinit var repository: CarroRepository

    @BeforeEach
    internal fun setUp() {
        repository.deleteAll()
    }

    @AfterEach
    internal fun tearDown() {
        repository.deleteAll()
    }

    @Test
    fun `deve inserir um novo carro`(){

        //cenário no afterEach

        //ação
        repository.save(Carro("Kicks","JKS2A46"))

        //validação
        assertEquals(1,repository.count())
    }

    @Test
    fun `deve encontrar carro por placa`(){

        //cenário
        repository.save(Carro("Toro", "JCK0489"))

        //ação
        val existsByPlaca = repository.existsByPlaca("JCK0489")

        //validação
        assertTrue(existsByPlaca)

    }

}
