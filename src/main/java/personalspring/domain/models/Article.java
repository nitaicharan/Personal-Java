package personalspring.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Article extends BaseModel {
    private String slug;
    private String body;
    private String description;
    private boolean favorited;
    private int favoritesCount;
    private String title;

    private Article(
            UUID id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String slug,
            String body,
            String description,
            boolean favorited,
            int favoritesCount,
            String title) {

        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
        setSlug(slug);
        setBody(body);
        setDescription(description);
        setFavorited(favorited);
        setFavoritesCount(favoritesCount);
        setTitle(title);
    }

    public void setSlug(String slug) {
        if (slug == null || slug.trim().isEmpty()) {
            throw new IllegalArgumentException("Slug cannot be null or empty");
        }
        this.slug = slug;
    }

    public void setBody(String body) {
        if (body == null || body.trim().isEmpty()) {
            throw new IllegalArgumentException("Body cannot be null or empty");
        }
        this.body = body;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public void setFavoritesCount(int favoritesCount) {
        if (favoritesCount < 0) {
            throw new IllegalArgumentException("Favorites count cannot be negative");
        }
        this.favoritesCount = favoritesCount;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    @Builder
    public static Article createArticle(
            UUID id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String slug,
            String body,
            String description,
            boolean favorited,
            int favoritesCount,
            String title) {

        return new Article(id, createdAt, updatedAt, slug, body, description, favorited, favoritesCount, title);
    }
}
