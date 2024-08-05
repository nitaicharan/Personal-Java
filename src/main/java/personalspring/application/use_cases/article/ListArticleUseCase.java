package personalspring.application.use_cases.article;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import personalspring.domain.models.Article;
import personalspring.domain.persistenceis.IArticlePersistency;

@Service
@AllArgsConstructor
public class ListArticleUseCase {
  private final IArticlePersistency repository;

  public List<Article> execute() {
    return this.repository.list();
  }
}
