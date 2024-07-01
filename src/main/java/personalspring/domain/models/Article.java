package personalspring.domain.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Article extends BaseModel {
  private String slug;
  private String body;
  private String description;
  private boolean favorited;
  private int favoritesCount;
  private String title;
  private String createdAt;
  private String updatedAt;
}
