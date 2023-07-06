package personalspring.infrastructure.controllers.article;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Locale;
import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.javafaker.Faker;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import personalspring.application.use_cases.article.CreateArticleUseCase;
import personalspring.application.use_cases.article.FindArticlesUseCase;
import personalspring.application.use_cases.article.ListArticlesUseCase;
import personalspring.domain.models.Article;

@WebMvcTest(ArticleController.class)
class ApplicationTest {
    @MockBean
    private ListArticlesUseCase listArticleUseCase;

    @MockBean
    private FindArticlesUseCase findArticlesUseCase;

    @MockBean
    private CreateArticleUseCase createArticleUseCase;

    @Autowired
    private MockMvc mockMvc;

    private Faker faker = new Faker(Locale.US);

    @BeforeEach
    void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.mockMvc(mockMvc);
        RestAssuredMockMvc.basePath = "/articles";
    }

    @Test
    void should_allow_list_article_whiout_authentication() {

        RestAssuredMockMvc.given()
                .auth().none()
                .accept(MediaType.ALL_VALUE)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void should_allow_find_article_whiout_authentication() {
        String slug = faker.name().fullName().replace(' ', '-').toLowerCase();
        UUID id = UUID.randomUUID();
        when(findArticlesUseCase.execut(slug)).thenReturn(Article.builder().id(id).slug(slug).build());

        var response = """
                    {"id":"%s","slug":"%s"}
                """.formatted(id, slug).trim();

        RestAssuredMockMvc.given()
                .auth().authentication(id)
                .accept(MediaType.ALL_VALUE)
                .when()
                .get("/{slug}", slug)
                .then()
                .body(Matchers.equalTo(response))
                .statusCode(200);
    }

    @Test
    void should_return_location_header_with_created_id_entity() throws Exception {
        var id = UUID.randomUUID();
        String slug = faker.name().fullName().replace(' ', '-').toLowerCase();

        when(createArticleUseCase.execut(any(Article.class))).thenReturn(id);

        this.mockMvc.perform(
                post("/articles")
                        .content("{\"slug\": \"%s\"}".formatted(slug))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location",
                        Matchers.equalTo("/articles/%s".formatted(id))));
    }
}