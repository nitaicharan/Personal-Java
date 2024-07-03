package personalspring.infrastructure.database.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import personalspring.infrastructure.database.entities.UserEntity;

public interface IUserPersister extends JpaRepository<UserEntity, UUID> {
  public Optional<UserEntity> findByUsername(String identifier);

  public Optional<UserEntity> findById(UUID id);

  @Transactional
  public void deleteByUsername(String slgu);
}
