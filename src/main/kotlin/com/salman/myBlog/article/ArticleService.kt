package com.salman.myBlog.article

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ArticleService(private val userRepository: ArticleRepository) {
    fun getArticles(): List<Article> {
        return userRepository.findAll()
    }

    fun addArticle(user: Article) {
        userRepository.save(user)
    }

    fun deleteArticle(userId: Long) {
        val exists: Boolean = userRepository.existsById(userId)
        if (!exists) {
            throw IllegalStateException("Article with ID:$userId doesn't exits")
        }
        userRepository.deleteById(userId)
    }

    @Transactional
    fun updateArticle(userId: Long, name: String?, email: String?, passwordHash: String?, profilePhoto: String?) {
        val user = userRepository.findById(userId)
            .orElseThrow { IllegalStateException("Article with ID:$userId doesn't exits") }

        if (name != null && name.isNotEmpty() && name != user.name) {
            user.name = name
        }

    }
}
