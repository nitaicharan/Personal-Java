package personalspring.application.use_cases.users;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import personalspring.domain.models.User;
import personalspring.domain.repositories.IUserRepository;

@Service
@AllArgsConstructor
public class ListUserUseCase {
  private final IUserRepository repository;

  public List<User> execute() {
    return this.repository.list();
  }
}
