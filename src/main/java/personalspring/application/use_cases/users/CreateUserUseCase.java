package personalspring.application.use_cases.users;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import personalspring.application.use_cases.base.CreateBaseUsecase;
import personalspring.domain.models.User;
import personalspring.domain.persistenceis.IUserPersistency;

@Service
@AllArgsConstructor
public class CreateUserUseCase extends CreateBaseUsecase<User> {
  private final IUserPersistency repository;

  public UUID execute(User model) {
    if (model == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    try {
      var saved = repository.create(model);
      return saved.getId();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
