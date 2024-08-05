package personalspring.infrastructure.database.implementations;

import org.springframework.stereotype.Repository;
import personalspring.domain.models.User;
import personalspring.domain.persistenceis.IUserPersistency;
import personalspring.infrastructure.database.entities.UserEntity;
import personalspring.infrastructure.database.interfaces.IUserRepository;

@Repository
public class UserRepositoryImp extends BaseRepositoryImpl<User, UserEntity>
    implements IUserPersistency {

  UserRepositoryImp(IUserRepository repository) {
    super(repository);
  }

  @Override
  public UserEntity fromModel(User model) {
    return new UserEntity(model);
  }
}
