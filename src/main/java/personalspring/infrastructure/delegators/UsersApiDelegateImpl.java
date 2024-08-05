package personalspring.infrastructure.delegators;

import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.application.use_cases.users.CreateUserUseCase;
import personalspring.application.use_cases.users.DeleteUserUseCase;
import personalspring.application.use_cases.users.FindUserUseCase;
import personalspring.application.use_cases.users.ListUserUseCase;
import personalspring.domain.models.User;
import personalspring.infrastructure.api.UsersApiDelegate;
import personalspring.infrastructure.dto.PaginationDto;
import personalspring.infrastructure.dto.UserDto;
import personalspring.infrastructure.dto.UsersList200ResponseDataInnerDto;
import personalspring.infrastructure.dto.UsersList200ResponseDto;

@Service
@AllArgsConstructor
public class UsersApiDelegateImpl implements UsersApiDelegate {
  private final CreateUserUseCase createUserUseCase;
  private final FindUserUseCase findUserUseCase;
  private final ListUserUseCase listUserUseCase;
  private final DeleteUserUseCase deleteUserUseCase;

  @Override
  public ResponseEntity<Void> usersDelete(UUID id) {
    deleteUserUseCase.execute(id);

    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<UsersList200ResponseDto> usersList(BigDecimal offset, BigDecimal limit) {
    var entities = this.listUserUseCase.execute();
    var data =
        entities.stream()
            .map(
                entity -> {
                  var response =
                      UsersList200ResponseDataInnerDto.builder()
                          .id(entity.getId())
                          .name(entity.getName())
                          .username(entity.getUsername())
                          .email(entity.getEmail())
                          .bio(entity.getBio())
                          .build();

                  ZoneOffset createdAtZoneOffset =
                      ZoneId.systemDefault().getRules().getOffset(entity.getCreatedAt());
                  OffsetDateTime createdAtOffsetDateTime =
                      entity.getCreatedAt().atOffset(createdAtZoneOffset);
                  response.setCreatedAt(createdAtOffsetDateTime);

                  ZoneOffset updatedAtZoneOffset =
                      ZoneId.systemDefault().getRules().getOffset(entity.getCreatedAt());
                  OffsetDateTime updatedAtOffsetDateTime =
                      entity.getCreatedAt().atOffset(updatedAtZoneOffset);
                  response.setUpdatedAt(updatedAtOffsetDateTime);

                  if (entity.getImage() != null) {
                    response.setImage(URI.create(entity.getImage()));
                  }

                  return response;
                })
            .toList();

    var respoonse =
        UsersList200ResponseDto.builder()
            .data(data)
            .pagination(PaginationDto.builder().build())
            .build();
    return ResponseEntity.ok(respoonse);
  }

  @Override
  public ResponseEntity<Void> usersPost(UserDto userDto) {
    if (userDto == null) {
      createUserUseCase.execute(null);
    }

    var model =
        User.builder()
            .name(userDto.getName())
            .username(userDto.getUsername())
            .email(userDto.getEmail())
            .bio(userDto.getBio())
            .build();

    if (userDto.getImage() != null) {
      model.setImage(userDto.getImage().toString());
    }

    var id = createUserUseCase.execute(model);
    return ResponseEntity.created(URI.create("/users/" + id)).build();
  }
}
