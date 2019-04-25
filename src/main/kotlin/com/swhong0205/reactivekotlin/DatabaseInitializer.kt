package com.swhong0205.reactivekotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DatabaseInitializer {
    @Autowired
    lateinit var customerRepository: CustomerRepository



}