package personalspring.infrastructure.database.entities;

import jakarta.persistence.Entity;
import personalspring.domain.models.Article;

@Entity
public class ArticleEntity extends BaseEntity {
    private String slug;

    @Override
    public Article toModel() {
        return Article.builder().slug(slug).build();
    }
}