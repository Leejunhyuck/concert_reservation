package org.raccoon.concert.user.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class UserVO (
        @Id
        @GeneratedValue
        var id : Long,
        var userId : String,
        var username : String,
        var passwrod : String,
        @CreationTimestamp
        var regdate : Timestamp,
        @UpdateTimestamp
        var updatedate : Timestamp

)
