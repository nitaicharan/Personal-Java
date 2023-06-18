package personalspring.application.use_cases.article;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@Service
@AllArgsConstructor
public class FindArticlesUseCase {
    private final IArticleRepository repository;

    public Article execut(String slug) {
        return this.repository.findBySlug(slug);
    }
}
