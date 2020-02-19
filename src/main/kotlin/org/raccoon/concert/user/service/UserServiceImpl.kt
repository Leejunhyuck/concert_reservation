package org.raccoon.concert.user.service

import org.raccoon.concert.user.dto.UserDto
import org.raccoon.concert.user.model.UserVO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired
    val userRepo : UserRepository
    @Autowired
    val 
    //콘서트 정보
) : UserService{
    fun mypage(User: UserVO): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(dto: UserDto): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        userRepo.save(UserVO)

    }

    override fun login(dto : UserDto) : UserVO{
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}