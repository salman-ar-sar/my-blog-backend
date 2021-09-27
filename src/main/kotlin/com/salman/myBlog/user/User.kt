package com.salman.myBlog.user

import java.time.LocalDate
import java.time.Month
import java.time.Period
import javax.persistence.*

@Entity
@Table(name = "users")
class User(id: Long = 0L,
           var name: String = "",
           var email: String = "",
           var dob: LocalDate = LocalDate.of(1900, Month.JANUARY, 1)) {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    var id: Long = id

    @Transient
    var age: Int = 0
        get() = Period.between(dob, LocalDate.now()).years
}