package personalspring.application.use_cases.article;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@Service
@AllArgsConstructor
public class CreateUseCase {
  private final IArticleRepository repository;

  public String execute(Article model) {
    var entity = repository.create(model);

    if (entity == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found");
    }

    return entity.getSlug();
  }
}
