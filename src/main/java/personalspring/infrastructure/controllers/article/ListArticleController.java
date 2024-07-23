package personalspring.infrastructure.controllers.article;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personalspring.application.use_cases.article.ListArticleUseCase;
import personalspring.domain.models.Article;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class ListArticleController {
  private final ListArticleUseCase useCase;

  @GetMapping
  public List<Article> handler() {
    return this.useCase.execute();
  }
}
