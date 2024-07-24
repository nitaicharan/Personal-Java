package personalspring.domain.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class User extends BaseModel {
  private String name;
  private String username;
  private String email;
  private String token;
  private String bio;
  private String image;
  private String password;
}
