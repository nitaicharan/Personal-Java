package personalspring.domain.repositories;

import java.util.List;
import personalspring.domain.models.User;

public interface IUserRepository {
  public User create(User model);

  public List<User> list();

  public User findByUsername(String identifier);

  public void deleteByUsername(String identifier);
}
