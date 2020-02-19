package org.raccoon.concert.user.controller

import org.raccoon.concert.user.dto.MyInfoDto
import org.raccoon.concert.user.dto.UserLoginDto
import org.raccoon.concert.user.dto.UserRegDto
import org.raccoon.concert.user.model.UserVO
import org.raccoon.concert.user.repositoy.UserRepository
import org.raccoon.concert.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("api/v1/user/*")
class UserController (
        @Autowired
        val service : UserService

){
  
    @PostMapping("/login")
    fun login(@RequestBody @Valid userDto: UserLoginDto) : ResponseEntity<UserVO>{
        var user = service.login(userDto)
        return ResponseEntity(user,HttpStatus.OK)
    }

    @PostMapping("/register")
    fun register(@RequestBody @Valid userRegDto: UserRegDto) : ResponseEntity<UserVO> {
        println(userRegDto)
        var result = service.register(userRegDto)
        return ResponseEntity (result, HttpStatus.CREATED)
    }

    @GetMapping("/mypage")
    fun mypage() : ResponseEntity<MyInfoDto> {
        //id 값을 얻어온다고 가정 (ex jwt,session)
        var id = "abc"
        var info = service.mypage(id)
        return ResponseEntity (info, HttpStatus.OK)
    }



}