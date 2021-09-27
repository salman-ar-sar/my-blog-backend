package com.salman.myBlog.article

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/articles"])
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    fun getArticles(): List<Article> {
        return articleService.getArticles()
    }

    @PostMapping
    fun registerArticle(@RequestBody article: Article) {
        articleService.addArticle(article)
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
