package org.raccoon.concert.concert.repositoy

import org.raccoon.concert.concert.model.ConcertVO
import org.springframework.data.repository.CrudRepository

interface ConcertRepository : CrudRepository<ConcertVO,Long>