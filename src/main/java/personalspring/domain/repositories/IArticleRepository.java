package personalspring.domain.repositories;

import java.util.List;

import personalspring.domain.models.Article;

public interface IArticleRepository {
    public List<Article> list();
    public Article findBySlug(String slug);
}
