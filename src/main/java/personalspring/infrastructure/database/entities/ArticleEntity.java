package personalspring.infrastructure.database.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Setter;
import lombok.ToString;
import personalspring.domain.models.Article;

@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity<Article> {

  @Column(nullable = false)
  private String slug;

  @Column(nullable = false)
  private String body;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private boolean favorited = false;

  @Column(nullable = false)
  private int favoritesCount = 0;

  @Column(nullable = false)
  private String title;

  @CreatedDate
  private String createdAt;

  @LastModifiedDate
  private String updatedAt;

  public ArticleEntity(Article model) {
    this.setId(model.getId());
    this.setSlug(model.getSlug());
    this.setBody(model.getBody());
    this.setDescription(model.getDescription());
    this.setFavorited(model.isFavorited());
    this.setFavoritesCount(model.getFavoritesCount());
    this.setTitle(model.getTitle());
    this.setCreatedAt(model.getCreatedAt());
    this.setUpdatedAt(model.getUpdatedAt());
  }

  @Override
  public Article toModel() {
    return Article.builder()
        .id(this.getId())
        .slug(this.slug)
        .body(this.body)
        .description(this.description)
        .favorited(this.favorited)
        .favoritesCount(this.favoritesCount)
        .title(this.title)
        .createdAt(this.createdAt)
        .updatedAt(this.updatedAt)
        .build();
  }

}
