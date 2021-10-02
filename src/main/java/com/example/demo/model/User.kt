package com.example.demo.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
@Entity(name = "userDetail")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = 0,

    val firstname: String? = "Basar",

    val lastname: String? = "Emirhan",

    // TODO must be unique
    @NotNull
    var email: String,

    @NotBlank
    @NotNull
    @Size(max = 20)
    var username: String,

    @NotBlank
    @NotNull
    @Size(
        min = 6,
        max = 20,
        message = "Password must be between 6 and 20 characters"
    )
    var password: String,

    val balance: BigDecimal? = BigDecimal.valueOf(900),

    @Enumerated(EnumType.ORDINAL)
    val creditNote: CreditNote = CreditNote.C,

    @ManyToOne
    @JoinColumn(name = "credit_id", foreignKey = ForeignKey(name = "FK_credit_id"))
    var creditId: Credit? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: Set<Role>? = HashSet()
)