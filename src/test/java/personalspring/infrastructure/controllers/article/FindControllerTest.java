package personalspring.infrastructure.controllers.article;

import static org.mockito.Mockito.when;

import java.util.Locale;
import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.github.javafaker.Faker;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import personalspring.application.use_cases.article.CreateUseCase;
import personalspring.application.use_cases.article.FindUseCase;
import personalspring.application.use_cases.article.ListUseCase;
import personalspring.domain.models.Article;

@WebMvcTest(CreateController.class)
public class FindControllerTest {
  @MockBean
  private ListUseCase listArticleUseCase;

  @MockBean
  private FindUseCase findArticlesUseCase;

  @MockBean
  private CreateUseCase createArticleUseCase;

  @Autowired
  private MockMvc mockMvc;

  private Faker faker = new Faker(Locale.US);

  @BeforeEach
  void initialiseRestAssuredMockMvcStandalone() {
    RestAssuredMockMvc.mockMvc(mockMvc);
    RestAssuredMockMvc.basePath = "/articles";
  }

  @Test
  void should_allow_find_article_whiout_authentication() {
    String slug = faker.name().fullName().replace(' ', '-').toLowerCase();
    UUID id = UUID.randomUUID();
    when(findArticlesUseCase.execute(slug)).thenReturn(Article.builder().id(id).slug(slug).build());

    var response = """
        {"id":"%s","slug":"%s"}
        """.formatted(id, slug).trim();

    // RestAssuredMockMvc.given()
    //     .auth().authentication(id)
    //     .accept(MediaType.ALL_VALUE)
    //     .when()
    //     .get("/{slug}", slug)
    //     .then()
    //     .body(Matchers.equalTo(response))
    //     .statusCode(200)
    //     .log().all()
    //     .extract()
    //     .response();

  }
}
