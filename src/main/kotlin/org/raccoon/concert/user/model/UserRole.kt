package org.raccoon.concert.user.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import javax.persistence.Table


@Entity
@Table(name = "roles")
@EqualsAndHashCode(of = "fno")
@ToString
public class MemberRole{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rno;
  
  private String roleName;
    
}