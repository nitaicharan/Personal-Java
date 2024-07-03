package personalspring.application.dto.users;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import personalspring.domain.models.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

  @NotBlank
  private String username;

  @NotBlank
  private String email;

  @NotBlank
  private String password;

  public User toModel() {
    return User.builder()
        .username(this.username)
        .email(this.email)
        .password(this.password)
        .build();
  }
}
