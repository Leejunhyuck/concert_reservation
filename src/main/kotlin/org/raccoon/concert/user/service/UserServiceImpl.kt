package org.raccoon.concert.user.service

import org.raccoon.concert.user.dto.UserDto
import org.raccoon.concert.user.model.UserVO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(

) : UserService{
    fun mypage(User: UserVO): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(dto: UserDto): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun login(dto : UserDto) : UserVO{
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}