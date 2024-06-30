package personalspring.application.dto.article;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import personalspring.domain.models.Article;

@Data
public class CreateDto {
  @NotNull
  private String slug;

  public Article toModel() {
    return Article.builder().slug(this.slug).build();
  }
}
