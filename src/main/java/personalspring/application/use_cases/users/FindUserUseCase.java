package personalspring.application.use_cases.users;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import personalspring.domain.models.User;
import personalspring.domain.repositories.IUserRepository;

@Service
@AllArgsConstructor
public class FindUserUseCase {
  private final IUserRepository repository;

  public User execute(String identifier) throws ResponseStatusException {
    var model = this.repository.findByUsername(identifier);

    if (model == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
    }

    return model;
  }
}
