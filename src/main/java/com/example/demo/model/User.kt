package com.example.demo.model

import java.math.BigDecimal
import javax.persistence.*

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
@Entity(name = "userDetail")
data class User(
    @Id
    val id: Long,
    var name: String,
    var creditNote: CreditNote,
    var balance: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "credit_id", foreignKey = ForeignKey(name = "FK_credit_id"))
    var creditId: Credit
)
