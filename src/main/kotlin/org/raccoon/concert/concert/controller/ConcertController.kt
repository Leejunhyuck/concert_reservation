package org.raccoon.concert.concert.controller

import org.raccoon.concert.concert.service.ConcertService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/concerts/*")
class ConcertController (
        @Autowired
        val concertService : ConcertService
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


    @PostMapping()
    fun registerConcert(){


    }

    @PutMapping("/{concertId}")
    fun updateConcert(){

    }

    @DeleteMapping("/{concertId}")
    fun deleteConcert(){

    }














}