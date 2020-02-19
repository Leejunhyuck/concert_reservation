package org.raccoon.concert.concert.controller

import org.raccoon.concert.concert.service.ConcertService
import org.raccoon.concert.concert.service.ReserveService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/concerts/*")
class ConcertController (
        @Autowired
        val concertService : ConcertService,
        @Autowired
        val reserveService : ReserveService
){
    @PostMapping("/reservation/{concertId}/{seatNumber}")
    fun reserve(){

    }
    @PutMapping("/reservation/{concertId}/{seatNumber}")
    fun updateReservation(){

    }

    @GetMapping("/reservation/{concertId}")
    fun getReservation(){


    }

    @DeleteMapping("/reservation/{concertId}/{seatNumber}")
    fun deleteReservation(){

    }


    @PutMapping("/{concertId}")
    fun updateConcert(@PathVariable("concertId") cno : Long){

    }

    @DeleteMapping("/{concertId}")
    fun deleteConcert(@PathVariable("concertId") cno : Long){

    }

    @GetMapping("/{concertId}")
    fun getConcert(@PathVariable("concertId") cno : Long){


    }














}