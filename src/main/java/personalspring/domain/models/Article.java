package personalspring.domain.models;

import lombok.Builder;

@Builder
public class Article extends BaseModel {
    private String slug;
}
