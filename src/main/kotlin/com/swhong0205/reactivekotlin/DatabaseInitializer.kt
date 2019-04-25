package com.swhong0205.reactivekotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer {
    @Autowired
    lateinit var customerRepository: CustomerRepository


}