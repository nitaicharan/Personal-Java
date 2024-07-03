package personalspring.infrastructure.database.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.NoArgsConstructor;
import personalspring.domain.models.User;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "users")
public class UserEntity extends BaseEntity<User> {

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String token;

  @Column(nullable = false)
  private String bio;

  @Column(nullable = false)
  private String image;

  @Column(nullable = false)
  private String password;

  public UserEntity(User model) {
    this.setId(model.getId());
    this.username = model.getUsername();
    this.email = model.getEmail();
    this.token = model.getToken();
    this.bio = model.getBio();
    this.image = model.getImage();
    this.password = model.getPassword();
    this.setCreatedAt(model.getCreatedAt());
    this.setUpdatedAt(model.getUpdatedAt());
  }

  @Override
  public User toModel() {
    return User.builder()
        .id(this.getId())
        .username(this.username)
        .email(this.email)
        .token(this.token)
        .bio(this.bio)
        .image(this.image)
        .password(this.password)
        .createdAt(this.getCreatedAt())
        .updatedAt(this.getUpdatedAt())
        .build();
  }

}
