package personalspring.infrastructure.controllers.users;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.dto.users.CreateUserDto;
import personalspring.application.use_cases.users.CreateUserUseCase;

@AllArgsConstructor
@RestController
@RequestMapping("users")
public class CreateUserController {
  private final CreateUserUseCase useCase;

  @PostMapping
  public ResponseEntity<Void> handler(@RequestBody CreateUserDto dto) {
    var model = dto.toModel();
    var slug = this.useCase.execute(model);

    var location = URI.create("/users/%s".formatted(slug.toString()));
    return ResponseEntity.created(location).build();
  }
}
