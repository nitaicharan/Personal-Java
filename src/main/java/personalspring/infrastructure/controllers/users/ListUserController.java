package personalspring.infrastructure.controllers.users;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personalspring.application.use_cases.users.ListUserUseCase;
import personalspring.domain.models.User;

@AllArgsConstructor
@RestController
@RequestMapping("users")
public class ListUserController {
  private final ListUserUseCase useCase;

  @GetMapping
  public List<User> handler() {
    return this.useCase.execute();
  }
}
