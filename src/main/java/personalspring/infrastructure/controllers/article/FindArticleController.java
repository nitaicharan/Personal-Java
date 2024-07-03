package personalspring.infrastructure.controllers.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.use_cases.article.FindArticleUseCase;
import personalspring.domain.models.Article;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class FindArticleController {
  private final FindArticleUseCase useCase;

  @GetMapping("/{slug}")
  public Article handler(@PathVariable("slug") String slug) {
    return this.useCase.execute(slug);
  }

}
