package org.raccoon.concert.user.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*


enum class UserRole{
  ADMIN, USER
}