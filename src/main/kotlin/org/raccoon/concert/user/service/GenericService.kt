package org.raccoon.concert.user.service

import org.raccoon.concert.user.model.UserVO

interface GenericService<V,O>{
    fun register(dto : O) : UserVO
    fun login(dto : V) : UserVO

}