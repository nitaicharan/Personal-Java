package personalspring.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class BaseModel {
  private UUID id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
