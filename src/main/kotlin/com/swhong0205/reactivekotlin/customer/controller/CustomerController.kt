package com.swhong0205.reactivekotlin.customer.controller

import com.swhong0205.reactivekotlin.customer.service.CustomerService
import com.swhong0205.reactivekotlin.customer.model.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerSerivce: CustomerService

    @GetMapping(value = "/customer/{id}")
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Mono<Customer>> {
        val customer = customerSerivce.getCustomer(id)
        return ResponseEntity(customer, HttpStatus.OK)
    }

    @GetMapping(value = "/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) = customerSerivce.searchCustomers(nameFilter)

    @PostMapping(value = "/customer/")
    fun createCustomer(@RequestBody customerMono: Mono<Customer>) =
            ResponseEntity(customerSerivce.createCustomer(customerMono), HttpStatus.CREATED)

}