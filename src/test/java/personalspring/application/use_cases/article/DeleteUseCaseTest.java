package personalspring.application.use_cases.article;

import static org.mockito.Mockito.doNothing;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.javafaker.Faker;

import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@ExtendWith(MockitoExtension.class)
class DeleteUseCaseTest {
  @Mock
  private IArticleRepository repository;

  @InjectMocks
  private DeleteUseCase useCase;

  private Faker faker = new Faker();

  @Test
  void should_delete_article_with_slug_in_case_of_exists() {
    var slug = faker.name().fullName().replace(' ', '-').toLowerCase();
    Article article = Article.builder().slug(slug).build();

    when(repository.findBySlug(slug)).thenReturn(article);
    doNothing().when(repository).deleteBySlug(slug);

    assertDoesNotThrow(() -> useCase.execute(slug));

    verify(repository).deleteBySlug(slug);
  }
}
