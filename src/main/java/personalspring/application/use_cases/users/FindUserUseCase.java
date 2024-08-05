package personalspring.application.use_cases.users;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.ws.rs.NotFoundException;
import personalspring.domain.models.User;
import personalspring.domain.persistenceis.IUserPersistency;

@Service
@AllArgsConstructor
public class FindUserUseCase {
  private final IUserPersistency repository;

  public User execute(UUID id) throws ResponseStatusException {
    var model = this.repository.findById(id);

    if (model == null) {
      throw new NotFoundException("User not found!");
    }

    return model;
  }
}
