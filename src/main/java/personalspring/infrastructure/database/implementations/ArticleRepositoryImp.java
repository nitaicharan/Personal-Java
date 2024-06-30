package personalspring.infrastructure.database.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;
import personalspring.infrastructure.database.entities.ArticleEntity;
import personalspring.infrastructure.database.interfaces.IArticlePersister;

@Repository
@AllArgsConstructor
public class ArticleRepositoryImp implements IArticleRepository {
  private IArticlePersister persister;

  @Override
  public Article create(Article model) {
    var entity = new ArticleEntity(model);

    var savedEntity = this.persister.save(entity);
    return savedEntity.toModel();
  }

  @Override
  public List<Article> list() {
    var entities = persister.findAll();
    return entities.stream().map(ArticleEntity::toModel).toList();
  }

  @Override
  public Article findBySlug(String slug) {
    return persister.findBySlug(slug).map(ArticleEntity::toModel).orElse(null);
  }

}
