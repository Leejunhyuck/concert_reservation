package org.raccoon.concert.concert.service


import org.raccoon.concert.concert.model.ReservationVO
import org.springframework.stereotype.Service

@Service
interface ReserveService  {
    fun getReserve(concertId:Long, userId:String ):ReservationVO
    fun deleteReserve(concertId:Long, seatNumber:Long, userId:String)
    fun updateReserve(concertId:Long, seatNumber:Long, userId:String)
    fun reserve(concertId:Long, userId:String, seatNumber:Long):ReservationVO
}