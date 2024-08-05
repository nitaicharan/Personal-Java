package personalspring.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseModel {
  protected UUID id;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;
}
