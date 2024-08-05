package personalspring.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class User extends BaseModel {
  private String name;
  private String username;
  private String email;
  private String bio;
  private String image;

  private User(
      UUID id,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      String name,
      String username,
      String email,
      String token,
      String bio,
      String image) {

    this.setId(id);
    this.setCreatedAt(createdAt);
    this.setUpdatedAt(updatedAt);
    setName(name);
    setUsername(username);
    setEmail(email);
    setBio(bio);
    setImage(image);
  }

  public void setName(String name) {
    if (name == null || name.length() < 1 || name.length() > 100) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Name cannot be null, must be at least 1 character, and less than or equal to 100"
              + " characters");
    }
    this.name = name;
  }

  public void setUsername(String username) {
    if (username == null
        || username.length() < 1
        || username.length() > 50
        || !username.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Username cannot be null, must be at least 1 character, less than or equal to 50"
              + " characters, and follow the pattern ^[a-zA-Z][a-zA-Z0-9_]*$");
    }
    this.username = username;
  }

  public void setEmail(String email) {
    if (email == null
        || email.length() < 5
        || email.length() > 100
        || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Email cannot be null, must be at least 5 characters, less than or equal to 100"
              + " characters, and be a valid email format");
    }
    this.email = email;
  }

  public void setBio(String bio) {
    if (bio != null && bio.length() > 500) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Bio must be less than or equal to 500 characters");
    }
    this.bio = bio;
  }

  public void setImage(String image) {
    if (image != null && image.toString().length() > 200) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Image URI must be less than or equal to 255 characters");
    }
    this.image = image;
  }

  @Builder
  public static User createUser(
      UUID id,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      String name,
      String username,
      String email,
      String token,
      String bio,
      String image) {

    return new User(id, createdAt, updatedAt, name, username, email, token, bio, image);
  }
}
