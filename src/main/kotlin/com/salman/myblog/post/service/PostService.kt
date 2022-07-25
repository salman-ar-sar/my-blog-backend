package com.salman.myblog.post.service

import com.salman.myblog.post.db.PostRepository
import com.salman.myblog.post.db.PostEntity
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class PostService(private val postRepository: PostRepository) {
    fun getPostsLength(): Long {
        return postRepository.count()
    }

    fun getPost(postId: Long): Optional<PostEntity> {
        return postRepository.findById(postId)
    }

    fun addPost(postEntity: PostEntity): PostEntity {
        return postRepository.save(postEntity)
    }

    fun deletePost(postId: Long) {
        val exists: Boolean = postRepository.existsById(postId)
        if (!exists) {
            throw IllegalStateException("Post with ID:$postId doesn't exits")
        }
        postRepository.deleteById(postId)
    }

    @Transactional
    fun updatePost(postId: Long, title: String?, image: String?) {
        val post = postRepository.findById(postId)
            .orElseThrow { IllegalStateException("Post with ID:$postId doesn't exits") }

        if (title != null && title.isNotEmpty() && title != post.title) {
            post.title = title
        }
        if (image != null && image.isNotEmpty() && image != post.image) {
            post.image = image
        }

    }
}
