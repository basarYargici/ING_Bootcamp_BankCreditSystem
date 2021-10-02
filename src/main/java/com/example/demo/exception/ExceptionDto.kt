package com.example.demo.exception

import org.springframework.http.HttpStatus
import java.sql.Timestamp

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 2.10.2021
 */
data class ExceptionDto(
    val message: String,
    val status: HttpStatus,
    val timestamp: Timestamp
)