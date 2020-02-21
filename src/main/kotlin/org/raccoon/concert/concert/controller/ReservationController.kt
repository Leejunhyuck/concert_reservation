package org.raccoon.concert.concert.controller


import org.raccoon.concert.concert.model.ReservationVO
import org.raccoon.concert.concert.service.ConcertService
import org.raccoon.concert.concert.service.ReserveService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/concerts/reservation")
class ReservationController (
        @Autowired
        val concertService : ConcertService,
        @Autowired
        val reserveService : ReserveService
){
    @PostMapping("/reservation/{concertId}/{seatNumber}")
    fun reserve(@PathVariable("concertId") cno : Long, @PathVariable("seatNumber") num : Long): ReservationVO {
        var userId = "abc"
        var result =reserveService.reserve(cno,userId,num)
        return result
    }
    @PutMapping("/reservation/{concertId}/{seatNumber}")
    fun updateReservation(@PathVariable("concertId") cno : Long, @PathVariable("seatNumber") num : Long): ReservationVO {
        var userId = "abc"
        var result =reserveService.updateReserve(cno,num,userId)
        return result
    }

    @GetMapping("/reservation/{concertId}")
    fun getReservation(@PathVariable("concertId") cno : Long, @PathVariable("seatNumber") num : Long): ReservationVO {
        var userId = "abc"
        var result =reserveService.getReserve(cno,userId)
        return result

    }

    @DeleteMapping("/reservation/{concertId}/{seatNumber}")
    fun deleteReservation(@PathVariable("concertId") cno : Long, @PathVariable("seatNumber") num : Long){
        var userId = "abc"
        var result =reserveService.deleteReserve(cno,num,userId)
        return result
    }
}