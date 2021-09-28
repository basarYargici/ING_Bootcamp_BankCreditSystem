package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
@Entity
data class Credit(
    @Id
    val id: Long,
    var extraPercentage: Float,
    var bankInterest: Float,
)