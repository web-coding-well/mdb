package com.junmeng.mdb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MdbApplication{
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MdbApplication::class.java, *args)
        }
    }
}



