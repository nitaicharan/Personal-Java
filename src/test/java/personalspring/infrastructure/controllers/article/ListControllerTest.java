package personalspring.infrastructure.controllers.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import personalspring.application.use_cases.article.CreateUseCase;
import personalspring.application.use_cases.article.FindUseCase;
import personalspring.application.use_cases.article.ListUseCase;

@SpringBootTest
@AutoConfigureMockMvc
public class ListControllerTest {
  @MockBean
  private ListUseCase listArticleUseCase;

  @MockBean
  private FindUseCase findArticlesUseCase;

  @MockBean
  private CreateUseCase createArticleUseCase;

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
        // .auth().none()
        .accept(MediaType.ALL_VALUE)
        .when()
        .get()
        .then()
        .statusCode(HttpStatus.OK.value());
  }
}
