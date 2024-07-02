package personalspring.infrastructure.controllers.article;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Locale;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.javafaker.Faker;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import personalspring.application.use_cases.article.CreateUseCase;
import personalspring.domain.models.Article;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateControllerTest {

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
  void should_return_location_header_with_created_id_entity() throws Exception {
    String slug = faker.name().fullName().replace(' ', '-').toLowerCase();

    when(createArticleUseCase.execute(any(Article.class))).thenReturn(slug);

    this.mockMvc.perform(
        post("/articles")
            .content("{\"slug\": \"%s\"}".formatted(slug))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.header().exists("Location"))
        .andExpect(MockMvcResultMatchers.header().string("Location",
            Matchers.equalTo("/articles/%s".formatted(slug))));
  }
}
