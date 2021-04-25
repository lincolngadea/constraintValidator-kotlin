package io.micronaut.kotlin

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("io.micronaut.kotlin")
		.start()
}

