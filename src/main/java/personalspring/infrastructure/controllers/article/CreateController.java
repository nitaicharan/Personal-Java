package personalspring.infrastructure.controllers.article;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import personalspring.application.dto.article.CreateDto;
import personalspring.application.use_cases.article.CreateUseCase;

@AllArgsConstructor
@RestController
@RequestMapping("articles")
public class CreateController {
  private final CreateUseCase useCase;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody CreateDto dto) {
    var model = dto.toModel();
    var slug = this.useCase.execute(model);

    var location = URI.create("/articles/%s".formatted(slug.toString()));
    return ResponseEntity.created(location).build();
  }
}
