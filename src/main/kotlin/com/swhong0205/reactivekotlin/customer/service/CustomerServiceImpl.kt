package com.swhong0205.reactivekotlin.customer.service

import com.swhong0205.reactivekotlin.customer.model.Customer
import com.swhong0205.reactivekotlin.customer.model.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int) = customerRepository.findById(id)

    override fun searchCustomers(nameFilter: String) = customerRepository.findCustomers(nameFilter)

    override fun createCustomer(customer: Mono<Customer>) = customerRepository.create(customer)

    override fun deleteCustomer(id: Int) = customerRepository.deleteById(id).map { it.deletedCount > 0 }
}