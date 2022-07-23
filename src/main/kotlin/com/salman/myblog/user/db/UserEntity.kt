package com.salman.myblog.user.db

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.Month
import java.time.Period
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    ) var id: Long = 0L,
    var name: String = "",
    var email: String = "",
    var passwordHash: String = "",
    var profilePhoto: String = "",
    var followers: Int = 0,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var dob: LocalDate = LocalDate.of(1900, Month.JANUARY, 1)
) {

    @get:Transient
    val age: Int
        get() = Period.between(dob, LocalDate.now()).years

    override fun toString(): String {
        return "User(name='$name', email='$email', dob=$dob, id=$id, age=$age)"
    }
}