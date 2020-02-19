package org.raccoon.concert.concert.service

import org.raccoon.concert.concert.model.ConcertVO
import org.raccoon.concert.user.model.UserVO

interface GenericService<Key,Val>{
    fun getItem(key : Key) : ConcertVO
    fun deleteItem(key : Key)
    fun updateItem(key : Key) : UserVO
}