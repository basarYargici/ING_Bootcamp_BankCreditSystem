package com.example.demo.dtos

import com.example.demo.model.Credit
import com.example.demo.model.CreditNote
import com.example.demo.model.Role
import java.math.BigDecimal
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 2.10.2021
 */
data class UserRegisterDto(
    val id: Long? = 0,

    val firstname: String = "Basar",

    val lastname: String = "Emirhan",

    @field:NotNull
    @field:Email
    var email: String = "be@gmail.com",

    @field:NotBlank
    @field:NotNull
    @field:Size(max = 20)
    var username: String,

    @field:NotBlank
    @field:NotNull
    @field:Size(
        min = 6,
        max = 20,
        message = "Password must be between 6 and 20 characters"
    )
    var password: String,

    val balance: BigDecimal = BigDecimal.valueOf(900),

    val creditNote: CreditNote? = CreditNote.C,

    var credit: Credit?,

    var roles: Set<Role>? = HashSet()
)