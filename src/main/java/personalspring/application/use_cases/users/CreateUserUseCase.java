package personalspring.application.use_cases.users;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import personalspring.domain.models.User;
import personalspring.domain.repositories.IUserRepository;

@Service
@AllArgsConstructor
public class CreateUserUseCase {
  private final IUserRepository repository;

  public String execute(User model) {
    var entity = repository.create(model);

    if (entity == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found");
    }

    return entity.getUsername();
  }
}
