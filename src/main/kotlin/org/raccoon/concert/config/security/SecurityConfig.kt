package org.raccoon.concert.config.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfig(
        @Autowired private val accountService: SecurityUserService,
        @Autowired private val passwordEncoder: PasswordEncoder): WebSecurityConfigurerAdapter() {

    companion object {
        const val LOGIN_SUCCESS_URL: String = "/view/success"
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService(accountService)
                .passwordEncoder(passwordEncoder)
    }

    override fun configure(http: HttpSecurity) {
        http.cors().disable()
                .csrf().disable()
                .antMatcher("/api/**").authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/api/v1/user/register").anonymous()
                .antMatchers("/api/v1/user/login").anonymous()
                .antMatchers("/api/v1/concerts").anonymous()
                .anyRequest().authenticated()
                .anyRequest().authenticated()
    }

    @Bean
    fun bCryptPasswordEncoder() : BCryptPasswordEncoder = BCryptPasswordEncoder()
}