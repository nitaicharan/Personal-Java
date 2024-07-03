package personalspring.domain.models;

import java.util.UUID;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class BaseModel {
  private UUID id;
  private String createdAt;
  private String updatedAt;
}
