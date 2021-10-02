package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
@Entity
data class Credit(
    //TODO validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = 0,
    var extraPercentage: Float,
    var bankInterest: Float,
)