package com.salman.myBlog.article

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "articles")
class Article(
    @Id @SequenceGenerator(
        name = "article_sequence",
        sequenceName = "article_sequence",
        allocationSize = 1
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "article_sequence"
    ) var id: Long = 0L,
    var name: String = "",
    var title: String = "",
    var author: String = "",
    var content: String = "",
    var image: String = "",
    var date: LocalDate = LocalDate.now()) {

    override fun toString(): String {
        return "Article(name='$name', title='$title', author='$author', content='$content', date=$date, id=$id)"
    }

}
