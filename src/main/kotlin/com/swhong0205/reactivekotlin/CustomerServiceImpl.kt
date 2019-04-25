package com.swhong0205.reactivekotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    companion object {
        val initialCustomers = arrayOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservice", Customer.Telephone("+44", "12345678")))
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customerRepository.findById(id)

    override fun searchCustomers(nameFilter: String) = customerRepository.findCustomers(nameFilter)

    override fun createCustomer(customer: Mono<Customer>) = customerRepository.create(customer)

    override fun deleteCustomer(id: Int) = customerRepository.deleteById(id).map { it.deletedCount > 0 }
}