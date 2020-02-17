package org.raccoon.concert.user.service

import org.raccoon.concert.user.dto.UserDto
import org.raccoon.concert.user.model.UserVO

interface UserService : GenericService<UserDto> {
    override fun register(dto : UserDto) : UserVO
    override fun login(dto : UserDto) : UserVO
}
