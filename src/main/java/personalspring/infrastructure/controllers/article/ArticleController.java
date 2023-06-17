package personalspring.infrastructure.controllers.article;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import personalspring.application.use_cases.article.ListArticlesUseCase;
import personalspring.domain.models.Article;

@RestController
@RequestMapping("articles")
@AllArgsConstructor
public class ArticleController {
    private final ListArticlesUseCase listArticlesUseCase;

    @GetMapping()
    List<Article> list(@PathParam("slug") String slug) {
        return this.listArticlesUseCase.execut();
    }

}
