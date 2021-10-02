package com.example.demo.dtos.converter

import com.example.demo.dtos.UserDto
import com.example.demo.dtos.UserRegisterDto
import com.example.demo.model.User
import org.springframework.stereotype.Component

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 2.10.2021
 */
@Component
class UserRegisterDtoConverter {
    fun convertToUser(userRegisterDto: UserRegisterDto): User {
        return User(
            userRegisterDto.id,
            userRegisterDto.firstname,
            userRegisterDto.lastname,
            userRegisterDto.email,
            userRegisterDto.username,
            userRegisterDto.password,
            userRegisterDto.balance,
            userRegisterDto.creditNote!!,
            userRegisterDto.creditId,
            userRegisterDto.roles
        )
    }

    fun convertToUserDto(user: User): UserDto {
        return UserDto(
            user.id,
            user.firstname,
            user.lastname,
            user.email,
            user.username,
            user.password,
            user.balance,
            user.creditNote,
            user.creditId,
            user.roles
        )
    }
}