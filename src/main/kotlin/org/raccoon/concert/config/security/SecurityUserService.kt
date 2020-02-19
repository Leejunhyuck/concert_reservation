package org.raccoon.concert.config.security

import org.raccoon.concert.user.model.UserVO
import org.raccoon.concert.user.repositoy.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityUserService(@Autowired private val repo: UserRepository): UserDetailsService
{
    override fun loadUserByUsername(username: String): UserDetails {
        var user = repo.findById(username)

        return SecurityUser(user = UserVO())
    }
}