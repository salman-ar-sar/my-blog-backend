package com.salman.myblog.post.controller

import com.salman.myblog.post.service.PostService
import com.salman.myblog.post.db.PostEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["api/v1/posts"])
class PostController(private val postService: PostService) {

    @GetMapping
    fun getPostsLength(): Long {
        return postService.getPostsLength()
    }

    @GetMapping(path = ["{postId}"])
    fun getPost(@PathVariable("postId") postId: Long): Optional<PostEntity> {
        return postService.getPost(postId)
    }

    @PostMapping
    fun addPost(@RequestBody postEntity: PostEntity): PostEntity {
        return postService.addPost(postEntity)
    }

    @DeleteMapping(path = ["{postId}"])
    fun deletePost(@PathVariable("postId") postId: Long) {
        postService.deletePost(postId)
    }

    @PutMapping(path = ["{postId}"])
    fun updatePost(
            @PathVariable("postId") postId: Long,
            @RequestParam(required = false) name: String?,
            @RequestParam(required = false) image: String?) {
        postService.updatePost(postId, name, image)
    }
}
