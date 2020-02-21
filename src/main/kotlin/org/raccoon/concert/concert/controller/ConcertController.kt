package org.raccoon.concert.concert.controller

import org.raccoon.concert.concert.model.ConcertVO
import org.raccoon.concert.concert.service.ConcertService
import org.raccoon.concert.user.model.UserVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/concerts/*")
class ConcertController (
        @Autowired
        val concertService : ConcertService
){
    @PutMapping("/{concertId}")
    fun updateConcert(@PathVariable("concertId") cno : Long) : ResponseEntity<UserVO> {
        var result =concertService.updateItem(cno)
        return ResponseEntity (result, HttpStatus.OK)
    }

    @DeleteMapping("/{concertId}")
    fun deleteConcert(@PathVariable("concertId") cno : Long): ResponseEntity<ConcertVO> {
        var result =concertService.getItem(cno)
        return ResponseEntity (result, HttpStatus.OK)
    }

    @GetMapping("/{concertId}")
    fun getConcert(@PathVariable("concertId") cno : Long): ResponseEntity<ConcertVO> {
        var result =concertService.getItem(cno)
        return ResponseEntity (result, HttpStatus.OK)
    }


}