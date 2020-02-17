package org.raccoon.concert.user.controller

import org.raccoon.concert.user.dto.UserDto
import org.raccoon.concert.user.model.UserVO
import org.raccoon.concert.user.repositoy.UserRepository
import org.raccoon.concert.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/user/*")
class UserController (
        @Autowired
        val service : UserService

){
    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto) : ResponseEntity<UserVO> {
        println(userDto)
        var name = service.register(userDto)

        return ResponseEntity (name, HttpStatus.OK)
    }


    @PostMapping("/login")
    fun login(){

    }

    @GetMapping("/mypage")
    fun mypage(){

    }



}