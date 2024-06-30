package personalspring.domain.models;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Article extends BaseModel {
  @Column(nullable = false)
  private String slug;
}
