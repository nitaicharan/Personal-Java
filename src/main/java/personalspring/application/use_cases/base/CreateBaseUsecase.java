package personalspring.application.use_cases.base;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import personalspring.domain.models.BaseModel;

@Service
@AllArgsConstructor
public abstract class CreateBaseUsecase<Model extends BaseModel> {
  public abstract UUID execute(Model model);
}
