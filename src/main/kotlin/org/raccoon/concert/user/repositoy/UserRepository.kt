package org.raccoon.concert.user.repositoy

import org.raccoon.concert.user.model.UserVO
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<UserVO,Long>
