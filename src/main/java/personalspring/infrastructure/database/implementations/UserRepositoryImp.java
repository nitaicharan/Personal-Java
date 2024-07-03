package personalspring.infrastructure.database.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import personalspring.domain.models.User;
import personalspring.domain.repositories.IUserRepository;
import personalspring.infrastructure.database.entities.UserEntity;
import personalspring.infrastructure.database.interfaces.IUserPersister;

@Repository
@AllArgsConstructor
public class UserRepositoryImp implements IUserRepository {
  private IUserPersister persister;

  @Override
  public User create(User model) {
    var entity = new UserEntity(model);

    var savedEntity = this.persister.save(entity);
    return savedEntity.toModel();
  }

  @Override
  public List<User> list() {
    var entities = persister.findAll();
    return entities.stream().map(UserEntity::toModel).toList();
  }

  @Override
  public User findByUsername(String identifier) {
    return persister.findByUsername(identifier).map(UserEntity::toModel).orElse(null);
  }

  @Override
  public void deleteByUsername(String identifier) {
    persister.deleteByUsername(identifier);
  }

}
