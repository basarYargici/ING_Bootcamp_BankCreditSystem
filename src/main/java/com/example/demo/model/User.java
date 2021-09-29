package com.example.demo.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    // sisteme giriş yaparken kullanıcı adı
    @NotBlank
    @Size(max = 20)
    @Column(name="username",unique = true)
    private String username;

    @Column(name="balance")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "creditNote")
    private CreditNote creditNote;

    @Column(name = "password")
    @NotBlank
    @NotNull
    @Size(min = 6, max = 20, message = "About Me must be between 6 and 20 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",referencedColumnName = "id"
            )
    )

    private Set<Role> roles  = new HashSet<>();


}
