package personalspring.infrastructure.controllers.article;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import personalspring.application.use_cases.article.FindArticlesUseCase;
import personalspring.application.use_cases.article.ListArticlesUseCase;
import personalspring.domain.models.Article;

@WebMvcTest(ArticleController.class)
class ApplicationTest {
    @MockBean
    private ListArticlesUseCase listArticleUseCase;

    @MockBean
    private FindArticlesUseCase findArticlesUseCase;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.mockMvc(mockMvc);
        RestAssuredMockMvc.basePath = "/articles";
    }

    @Test
    void should_allow_list_article_whiout_authentication() {
        when(listArticleUseCase.execut()).thenReturn(List.of(Article.builder().slug("").build()));

        RestAssuredMockMvc.given()
                .auth().none()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    void should_allow_find_article_whiout_authentication() {
        var slug = "lajksjsljsjs";
        when(findArticlesUseCase.execut(slug)).thenReturn(Article.builder().slug(slug).build());

        RestAssuredMockMvc.given()
                .auth().none()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get("/{slug}", slug)
                .then()
                .statusCode(200);
    }
}