package personalspring.application.use_cases.article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;

import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

class FindArticlesUseCaseTest {
    @Mock
    private IArticleRepository repository;

    @InjectMocks
    private FindArticlesUseCase useCase;

    private Faker faker = new Faker();

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_return_article_with_slug_in_case_of_success() {
        var slug = faker.name().fullName().replace(' ', '-').toLowerCase();
        when(repository.findBySlug(slug)).thenReturn(Article.builder().slug(slug).build());

        var result = useCase.execut(slug);
        assertEquals(result.getSlug(), slug);
    }

    @Test
    void should_thorw_not_found_exeption_in_case_of_response_null_from_repository() {
        when(repository.findBySlug(anyString())).thenReturn(null);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            useCase.execut("");
        });

        ResponseStatusException exeptionExpected = new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found!");
        assertEquals(exeptionExpected.getStatusCode(), exception.getStatusCode());
        assertEquals(exeptionExpected.getMessage(), exception.getMessage());
    }
}
