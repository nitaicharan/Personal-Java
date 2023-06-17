package personalspring.infrastructure.controllers.article;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import personalspring.application.use_cases.article.ListArticlesUseCase;

@WebMvcTest(ArticleController.class)
class ApplicationTest {
    @MockBean
    private ListArticlesUseCase useCase;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.mockMvc(mockMvc);
        RestAssuredMockMvc.basePath = "/articles";
    }

    @Test
    void should_allow_list_article_whiout_authentication() {
        RestAssuredMockMvc.given()
                .auth().none()
                .when()
                .get()
                .then()
                .body("$.size()", Matchers.equalTo(0))
                .statusCode(200);
    }

}