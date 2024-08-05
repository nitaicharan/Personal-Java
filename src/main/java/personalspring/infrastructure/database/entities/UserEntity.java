package personalspring.infrastructure.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import personalspring.domain.models.User;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "users")
public class UserEntity extends BaseEntity<User> {

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = true, length = 500)
  private String bio;

  @Column(nullable = true, length = 2000)
  private String image;

  public UserEntity(User model) {
    this.setId(model.getId());
    this.username = model.getUsername();
    this.name = model.getName();
    this.email = model.getEmail();
    this.bio = model.getBio();
    this.setCreatedAt(model.getCreatedAt());
    this.setUpdatedAt(model.getUpdatedAt());

    if (model.getImage() != null) {
      this.image = model.getImage().toString();
    }
  }

  @Override
  public User toModel() {
    return User.builder()
        .id(this.getId())
        .name(this.getName())
        .username(this.username)
        .email(this.email)
        .bio(this.bio)
        .image(this.image)
        .createdAt(this.getCreatedAt())
        .updatedAt(this.getUpdatedAt())
        .build();
  }
}
