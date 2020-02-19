package org.raccoon.concert.user.service

import org.raccoon.concert.concert.repositoy.ReseveRepository
import org.raccoon.concert.config.security.SecurityUserService
import org.raccoon.concert.user.dto.MyInfoDto
import org.raccoon.concert.user.dto.UserLoginDto
import org.raccoon.concert.user.dto.UserRegDto
import org.raccoon.concert.user.model.UserVO
import org.raccoon.concert.user.repositoy.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
        @Autowired
        val userRepo: UserRepository,
        @Autowired
        val reserveRepo: ReseveRepository,
        @Autowired
        val service: SecurityUserService,
        @Autowired
        val authenticationManager: AuthenticationManager
        //
        //콘서트 정보
) : UserService{
    override fun mypage(id: String): MyInfoDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var userInfo = userRepo.findById(id)
        //예외처리
        var reserveInfo = reserveRepo.findById(id)
        //예외처리
        if(userInfo.isPresent ) return MyInfoDto(userInfo.get(),reserveInfo)
    }

    override fun register(dto: UserRegDto): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return userRepo.save(dto.toEntity(BCryptPasswordEncoder()))
    }

    override fun login(dto: UserLoginDto): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var user = userRepo.findById(dto.userId)
        //user가 없다면 예외처리

        var userDetails = service.loadUserByUsername(dto.userId)
        var auth = UsernamePasswordAuthenticationToken(dto.userId, dto.password)
        authenticationManager.authenticate(auth)

        if (auth.isAuthenticated) {
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        if(user.isPresent) return user.get()

        //없으면 예외처리

    }


}