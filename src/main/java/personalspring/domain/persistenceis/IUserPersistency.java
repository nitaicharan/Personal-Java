package personalspring.domain.persistenceis;

import java.util.List;
import personalspring.domain.models.User;

public interface IUserPersistency extends IBasePersistency<User> {
  public List<User> findByEmailOrUsername(String email, String username);
}
