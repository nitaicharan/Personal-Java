package personalspring.application.dto.article;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import personalspring.domain.models.Article;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDto {

  @NotBlank private String body;

  @NotBlank private String description;

  @NotBlank private String slug;

  // @NotEmpty
  // private String[] tagList;

  @NotBlank private String title;

  public Article toModel() {
    return Article.builder()
        .body(this.body)
        .description(this.description)
        .slug(this.slug)
        .title(this.title)
        .build();
  }
}
