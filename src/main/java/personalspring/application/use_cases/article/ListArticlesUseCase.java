package personalspring.application.use_cases.article;

import java.util.List;

import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

public class ListArticlesUseCase {
    private final IArticleRepository repository;

    public ListArticlesUseCase(IArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> execut() {
        return this.repository.list();
    }
}
