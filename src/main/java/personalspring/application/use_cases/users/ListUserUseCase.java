package personalspring.application.use_cases.users;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import personalspring.domain.models.User;
import personalspring.domain.persistenceis.IUserPersistency;

@Service
@AllArgsConstructor
public class ListUserUseCase {
  private final IUserPersistency repository;

  public List<User> execute() {
    return this.repository.list();
  }
}
