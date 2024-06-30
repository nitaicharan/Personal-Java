package personalspring.infrastructure.database.entities;

import jakarta.persistence.Entity;
import lombok.Setter;
import lombok.ToString;
import personalspring.domain.models.Article;

@Setter
@ToString
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity<Article> {
  private String slug;

  public ArticleEntity(Article model) {
    this.setId(model.getId());
    this.setSlug(model.getSlug());
  }

  @Override
  public Article toModel() {
    return Article.builder().slug(slug).build();
  }

}
