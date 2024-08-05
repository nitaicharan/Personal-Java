package personalspring.application.use_cases.article;

import jakarta.ws.rs.InternalServerErrorException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import personalspring.domain.models.Article;
import personalspring.domain.persistenceis.IArticlePersistency;

@Service
@AllArgsConstructor
public class CreateArticleUseCase {

  private final IArticlePersistency repository;

  public UUID execute(Article model) {
    try {

      var saved = repository.create(model);

      if (saved == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found");
      }

      return saved.getId();
    } catch (Exception e) {
      throw new InternalServerErrorException();
    }
  }
}
