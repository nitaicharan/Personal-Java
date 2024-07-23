package personalspring.application.use_cases.article;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@Service
@AllArgsConstructor
public class FindArticleUseCase {
  private final IArticleRepository repository;

  public Article execute(String slug) throws ResponseStatusException {
    var model = this.repository.findBySlug(slug);

    if (model == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found!");
    }

    return model;
  }
}
