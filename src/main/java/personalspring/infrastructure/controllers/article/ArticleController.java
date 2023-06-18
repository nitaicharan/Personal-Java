package personalspring.infrastructure.controllers.article;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.use_cases.article.FindArticlesUseCase;
import personalspring.application.use_cases.article.ListArticlesUseCase;
import personalspring.domain.models.Article;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class ArticleController {
    private final ListArticlesUseCase listArticlesUseCase;
    private final FindArticlesUseCase findArticlesUseCase;

    @GetMapping()
    List<Article> list() {
        return this.listArticlesUseCase.execut();
    }

    @GetMapping("/{slug}")
    Article find(@PathVariable("slug") String slug) {
        return this.findArticlesUseCase.execut(slug);
    }

}
