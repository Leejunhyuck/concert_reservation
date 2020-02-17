package org.raccoon.concert.concert.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "concert")
data class ConcertVO (
        @Id
        @GeneratedValue
        var id : String,
        var concertName : String,
        var startTime : String,
        var endTime : String,
        var seats : Int,
        @CreationTimestamp
        var regdate : Timestamp,
        @UpdateTimestamp
        var updatedate : Timestamp

)