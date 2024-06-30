package personalspring.domain.models;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class Article extends BaseModel {
  private String slug;
}
