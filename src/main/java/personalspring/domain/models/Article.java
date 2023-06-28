package personalspring.domain.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Article extends BaseModel {
    private String slug;
}
