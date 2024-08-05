package personalspring.infrastructure.database.implementations;

import java.util.List;
import org.springframework.stereotype.Repository;
import personalspring.domain.models.User;
import personalspring.domain.persistenceis.IUserPersistency;
import personalspring.infrastructure.database.entities.UserEntity;
import personalspring.infrastructure.database.interfaces.IUserRepository;

@Repository
public class UserRepositoryImp extends BaseRepositoryImpl<User, UserEntity>
    implements IUserPersistency {
  private IUserRepository repository;

  UserRepositoryImp(IUserRepository repository) {
    super(repository);
  }

  @Override
  public List<User> findByEmailOrUsername(String email, String username) {
    var entities = this.repository.findByEmailOrUsername(email, username);
    return entities.stream().map(UserEntity::toModel).toList();
  }

  @Override
  public UserEntity fromModel(User model) {
    return new UserEntity(model);
  }
}
