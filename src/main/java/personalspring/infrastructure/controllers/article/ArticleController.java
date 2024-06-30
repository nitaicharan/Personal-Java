package personalspring.infrastructure.controllers.article;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.dto.article.CreateArticleDto;
import personalspring.application.use_cases.article.CreateArticleUseCase;
import personalspring.application.use_cases.article.FindArticlesUseCase;
import personalspring.application.use_cases.article.ListArticlesUseCase;
import personalspring.domain.models.Article;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class ArticleController {
  private final ListArticlesUseCase listArticlesUseCase;
  private final FindArticlesUseCase findArticlesUseCase;
  private final CreateArticleUseCase createArticleUseCase;

  @PostMapping
  ResponseEntity<Void> create(@RequestBody CreateArticleDto model) {
    var id = this.createArticleUseCase.execute(model.toModel());

    var location = URI.create("/articles/%s".formatted(id.toString()));
    return ResponseEntity.created(location).build();
  }

  @GetMapping
  List<Article> list() {
    return this.listArticlesUseCase.execute();
  }

  @GetMapping("/{slug}")
  Article find(@PathVariable("slug") String slug) {
    return this.findArticlesUseCase.execute(slug);
  }

}
