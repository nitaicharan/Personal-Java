package personalspring.infrastructure.database.interfaces;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import personalspring.infrastructure.database.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
  public List<UserEntity> findByEmailOrUsername(String email, String username);
}
