package personalspring.application.use_cases.users;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import personalspring.domain.repositories.IUserRepository;

@Service
@AllArgsConstructor
public class DeleteUserUseCase {
  private final IUserRepository repository;

  public void execute(String identifier) throws ResponseStatusException {
    var model = this.repository.findByUsername(identifier);

    if (model == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
    }

    this.repository.deleteByUsername(identifier);
  }
}
