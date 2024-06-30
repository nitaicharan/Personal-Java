package personalspring.application.use_cases.article;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@Service
@AllArgsConstructor
public class FindUseCase {
    private final IArticleRepository repository;

    public Article execute(String slug) throws ResponseStatusException {
        var model = this.repository.findBySlug(slug);

        if (model == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found!");
        }

        return model;
    }
}
