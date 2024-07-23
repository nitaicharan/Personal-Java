package personalspring.infrastructure.controllers.article;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personalspring.application.use_cases.article.DeleteArticleUseCase;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class DeleteArticleController {
  private final DeleteArticleUseCase useCase;

  @DeleteMapping("/{slug}")
  public ResponseEntity<Void> handler(@PathVariable String slug) {
    this.useCase.execute(slug);

    return ResponseEntity.ok().build();
  }
}
