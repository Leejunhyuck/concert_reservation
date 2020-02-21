package org.raccoon.concert.concert.service

import org.raccoon.concert.concert.model.ReservationVO
import org.raccoon.concert.concert.repositoy.ReseveRepository
import org.springframework.beans.factory.annotation.Autowired

class ReservationImpl (
        @Autowired
        val reserveRepo : ReseveRepository
) : ReserveService{
    override fun getReserve(concertId: Long, userId: String): ReservationVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var reserve = reserveRepo.findById(userId)
        return reserve
    }

    override fun deleteReserve(concertId: Long, seatNumber: Long, userId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var reserve = reserveRepo.deleteById(concertId)
        return reserve
    }

    override fun updateReserve(concertId: Long, seatNumber: Long, userId: String): ReservationVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var check=reserveRepo.findById(userId)
        check?:return ReservationVO(userId,concertId,seatNumber)

        var reserveItem = ReservationVO(userId,concertId,seatNumber)
        var reserve = reserveRepo.save(reserveItem)
        return reserve

    }

    override fun reserve(concertId: Long, userId: String, seatNumber: Long):ReservationVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var reserveItem = ReservationVO(userId,concertId,seatNumber)
        var reserve = reserveRepo.save(reserveItem)
        return reserve
    }
}