package org.raccoon.concert.concert.service

import org.raccoon.concert.user.dto.UserDto
import org.raccoon.concert.user.model.UserVO

interface ConcertService : GenericService<UserDto> {
    override fun register(dto : UserDto) : UserVO
    override fun login(dto : UserDto) : UserVO
}
