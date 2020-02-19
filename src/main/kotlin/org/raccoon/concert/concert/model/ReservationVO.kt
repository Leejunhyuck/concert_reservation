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
        var userId : String,
        var concert: Long,
        var seatNum : Long
//        @CreationTimestamp
//        var regdate : Timestamp,
//        @UpdateTimestamp
//        var updatedate : Timestamp
) {
        constructor() : this(userId = "", concert = 0, seatNum = 0)
}
