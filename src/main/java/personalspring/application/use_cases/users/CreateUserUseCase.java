package personalspring.application.use_cases.users;

import java.util.List;
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
    this.validation(model);

    try {
      var saved = repository.create(model);
      return saved.getId();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  private void validation(User model) {
    List<User> saved = null;

    if (model == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    try {
      saved = repository.findByEmailOrUsername(model.getEmail(), model.getUsername());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    if (saved != null && saved.size() != 0) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
    }
  }
}
