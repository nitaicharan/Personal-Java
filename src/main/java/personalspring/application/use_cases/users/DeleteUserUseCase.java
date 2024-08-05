package personalspring.application.use_cases.users;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.ws.rs.NotFoundException;
import personalspring.domain.persistenceis.IUserPersistency;

@Service
@AllArgsConstructor
public class DeleteUserUseCase {
  private final IUserPersistency repository;

  public void execute(UUID id) throws ResponseStatusException {
    var model = this.repository.findById(id);

    if (model == null) {
      throw new NotFoundException("User not found!");
    }

    this.repository.deleteById(id);
  }
}
