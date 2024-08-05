package personalspring.domain.persistenceis;

import java.util.List;
import java.util.UUID;
import personalspring.domain.models.BaseModel;

public interface IBasePersistency<Model extends BaseModel> {
  public Model create(Model model);

  public List<Model> list();

  public Model findById(UUID id);

  public void deleteById(UUID id);
}
