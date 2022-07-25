package com.salman.myblog.post.db

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "posts")
data class PostEntity(
    @Id @SequenceGenerator(
        name = "post_sequence",
        sequenceName = "post_sequence",
        allocationSize = 1
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "post_sequence"
    ) var id: Long = 0L,
    var title: String = "",
    var author: String = "",
    @ElementCollection
    var content: List<String> = ArrayList(),
    var image: String = "",
    var date: LocalDate = LocalDate.now()) {

    override fun toString(): String {
        return "Post(title='$title', author='$author', content='$content', date=$date, id=$id)"
    }

}
