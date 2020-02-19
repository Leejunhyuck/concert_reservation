package org.raccoon.concert.user.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "user")
class UserVO (
        @Id
        var userId : String,
        var username : String,
        var password : String,

//        @CreationTimestamp
//        var regdate : Timestamp,
//        @UpdateTimestamp
//        var updatedate : Timestamp,

        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles :  MutableList<UserRole>

){
        constructor() : this(
                userId = "",
                username="",
                password = "",
                roles = mutableListOf(UserRole.USER)
        )
}
