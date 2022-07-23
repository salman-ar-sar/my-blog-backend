package com.salman.myBlog.post

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ArticleService(private val articleRepository: ArticleRepository) {
    fun getArticles(): List<PostEntity> {
        return articleRepository.findAll()
    }

    fun addArticle(postEntity: PostEntity) {
        articleRepository.save(postEntity)
    }

    fun deleteArticle(articleId: Long) {
        val exists: Boolean = articleRepository.existsById(articleId)
        if (!exists) {
            throw IllegalStateException("Article with ID:$articleId doesn't exits")
        }
        articleRepository.deleteById(articleId)
    }

    @Transactional
    fun updateArticle(articleId: Long, name: String?, image: String?) {
        val article = articleRepository.findById(articleId)
            .orElseThrow { IllegalStateException("Article with ID:$articleId doesn't exits") }

        if (name != null && name.isNotEmpty() && name != article.name) {
            article.name = name
        }
        if (image != null && image.isNotEmpty() && image != article.image) {
            article.image = image
        }

    }
}
