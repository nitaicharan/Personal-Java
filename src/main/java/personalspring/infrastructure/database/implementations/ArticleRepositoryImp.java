package personalspring.infrastructure.database.implementations;

import org.springframework.stereotype.Repository;
import personalspring.domain.models.Article;
import personalspring.domain.persistenceis.IArticlePersistency;
import personalspring.infrastructure.database.entities.ArticleEntity;
import personalspring.infrastructure.database.interfaces.IArticleRepository;

@Repository
public class ArticleRepositoryImp extends BaseRepositoryImpl<Article, ArticleEntity>
    implements IArticlePersistency {
  public ArticleRepositoryImp(IArticleRepository persister) {
    super(persister);
  }

  @Override
  public ArticleEntity fromModel(Article model) {
    return new ArticleEntity(model);
  }
}
