package org.raccoon.concert.user.dto

import org.raccoon.concert.user.model.UserRole
import org.raccoon.concert.user.model.UserVO
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.validation.constraints.NotNull

class UserRegDto(
        @NotNull var userId : String,
        @NotNull var username : String,
        @NotNull var password : String

) {
    fun toEntity(bCryptPasswordEncoder: BCryptPasswordEncoder) // ->?
            = UserVO(
            userId = userId,
            username = username,
            password = bCryptPasswordEncoder.encode(password),
            roles = mutableListOf(UserRole.USER)
    )

}