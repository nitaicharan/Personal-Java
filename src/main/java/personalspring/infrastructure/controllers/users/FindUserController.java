package personalspring.infrastructure.controllers.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.use_cases.users.FindUserUseCase;
import personalspring.domain.models.User;

@AllArgsConstructor
@RestController
@RequestMapping("users")
public class FindUserController {
  private final FindUserUseCase useCase;

  @GetMapping("/{username}")
  public User handler(@PathVariable("username") String username) {
    return this.useCase.execute(username);
  }

}
