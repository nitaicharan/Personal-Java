package personalspring.application.use_cases.article;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import personalspring.domain.persistenceis.IArticlePersistency;

@Service
@AllArgsConstructor
public class DeleteArticleUseCase {
  private final IArticlePersistency repository;

  public void execute(UUID id) throws ResponseStatusException {
    var model = this.repository.findById(id);

    if (model == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found!");
    }

    this.repository.deleteById(id);
  }
}
