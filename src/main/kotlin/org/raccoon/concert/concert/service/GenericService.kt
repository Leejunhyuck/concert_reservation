package org.raccoon.concert.concert.service

import org.raccoon.concert.user.model.UserVO

interface GenericService<VO>{
    fun register(dto : VO) : UserVO
    fun login(dto : VO) : UserVO
}