package com.salman.myblog.post

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/articles"])
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    fun getArticles(): List<PostEntity> {
        return articleService.getArticles()
    }

    @PostMapping
    fun addArticle(@RequestBody postEntity: PostEntity) {
        articleService.addArticle(postEntity)
    }

    @DeleteMapping(path = ["{articleId}"])
    fun deleteArticle(@PathVariable("articleId") articleId: Long) {
        articleService.deleteArticle(articleId)
    }

    @PutMapping(path = ["{articleId}"])
    fun updateArticle(
            @PathVariable("articleId") articleId: Long,
            @RequestParam(required = false) name: String?,
            @RequestParam(required = false) image: String?) {
        articleService.updateArticle(articleId, name, image)
    }
}
