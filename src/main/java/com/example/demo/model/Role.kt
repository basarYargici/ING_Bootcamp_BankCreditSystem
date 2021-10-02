package com.example.demo.model

import javax.persistence.*

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
 */
@Entity
@Table(name = "roles")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0

    @Column(unique = true, nullable = false)
    val name: String? = null

    override fun toString(): String {
        return "Role{id='$id'name='$name'}"
    }
}