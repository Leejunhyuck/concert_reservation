package org.raccoon.concert.concert.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name ="reservation")
class ReservationVO (
        @Id
        @GeneratedValue
        var id : Long,
        var userId : String,
        var concert: Int,
        var seatNum : Int,
        @CreationTimestamp
        var regdate : Timestamp,
        @UpdateTimestamp
        var updatedate : Timestamp

)
