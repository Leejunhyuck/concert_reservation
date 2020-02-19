package org.raccoon.concert.user.service

import org.raccoon.concert.user.dto.MyInfoDto
import org.raccoon.concert.user.dto.UserLoginDto
import org.raccoon.concert.user.dto.UserRegDto

interface UserService : GenericService<UserLoginDto,UserRegDto> {
    fun mypage(id : String): MyInfoDto
}
