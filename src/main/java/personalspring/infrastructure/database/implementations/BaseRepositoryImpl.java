package personalspring.infrastructure.database.implementations;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import personalspring.domain.models.BaseModel;
import personalspring.infrastructure.database.entities.BaseEntity;

@AllArgsConstructor
public abstract class BaseRepositoryImpl<
    Model extends BaseModel, Entity extends BaseEntity<Model>> {
  protected JpaRepository<Entity, UUID> repository;

  public Model create(Model model) {
    var entity = this.fromModel(model);

    var savedEntity = this.repository.save(entity);

    return savedEntity.toModel();
  }

  public List<Model> list() {
    var entities = repository.findAll();

    return entities.stream().map(Entity::toModel).toList();
  }

  public Model findById(UUID id) {
    return repository.findById(id).map(Entity::toModel).orElse(null);
  }

  public void deleteById(UUID id) {
    repository.deleteById(id);
  }

  public abstract Entity fromModel(Model model);
}
