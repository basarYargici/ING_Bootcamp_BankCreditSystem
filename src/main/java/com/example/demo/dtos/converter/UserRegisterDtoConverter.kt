package com.example.demo.dtos.converter

import com.example.demo.dtos.UserRegisterDto
import com.example.demo.model.User
import org.springframework.stereotype.Component

/**
 * Created by İbrahim Başar YARGICI at 2.10.2021
 */
@Component
class UserRegisterDtoConverter {
    fun userFromDto(userRegisterDto: UserRegisterDto): User {
        return User(
            userRegisterDto.id,
            userRegisterDto.firstname,
            userRegisterDto.lastname,
            userRegisterDto.email,
            userRegisterDto.username,
            userRegisterDto.password,
            userRegisterDto.balance,
            userRegisterDto.creditNote,
            userRegisterDto.creditId
        )
    }
}