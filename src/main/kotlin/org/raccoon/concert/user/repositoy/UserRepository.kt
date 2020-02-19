package org.raccoon.concert.user.repositoy

import org.raccoon.concert.user.model.UserVO
import org.springframework.data.repository.CrudRepository
import java.util.*


interface UserRepository : CrudRepository<UserVO,String>
