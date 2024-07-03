package personalspring.domain.repositories;

import java.util.List;

import personalspring.domain.models.Article;

public interface IArticleRepository {
  public Article create(Article model);

  public List<Article> list();

  public Article findBySlug(String identifier);

  public void deleteBySlug(String identifier);
}
