package org.raccoon.concert.concert.repositoy

import org.raccoon.concert.concert.model.ReservationVO
import org.springframework.data.repository.CrudRepository

interface ReseveRepository : CrudRepository<ReservationVO,String> {

}