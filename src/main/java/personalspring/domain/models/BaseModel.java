package personalspring.domain.models;

import java.util.UUID;

import lombok.Setter;

@Setter()
public abstract class BaseModel {
    private UUID id;
}
