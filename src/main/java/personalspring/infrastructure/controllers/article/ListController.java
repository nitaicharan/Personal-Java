package personalspring.infrastructure.controllers.article;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.use_cases.article.ListUseCase;
import personalspring.domain.models.Article;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class ListController {
  private final ListUseCase useCase;

  @GetMapping
  public List<Article> list() {
    return this.useCase.execute();
  }
}
