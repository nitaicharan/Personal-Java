package personalspring.infrastructure.delegators;

import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.application.use_cases.users.CreateUserUseCase;
import personalspring.application.use_cases.users.DeleteUserUseCase;
import personalspring.application.use_cases.users.FindUserUseCase;
import personalspring.application.use_cases.users.ListUserUseCase;
import personalspring.domain.models.User;
import personalspring.infrastructure.api.UsersApiDelegate;
import personalspring.infrastructure.dto.UserDto;
import personalspring.infrastructure.dto.UsersGet200ResponseDto;
import personalspring.infrastructure.dto.UsersList200ResponseDataInnerDto;
import personalspring.infrastructure.dto.UsersList200ResponseDto;
import personalspring.infrastructure.dto.UsersPostRequestDto;

@Service
@AllArgsConstructor
public class UsersApiDelegateImpl implements UsersApiDelegate {
  private final CreateUserUseCase createUserUseCase;
  private final FindUserUseCase findUserUseCase;
  private final ListUserUseCase listUserUseCase;
  private final DeleteUserUseCase deleteUserUseCase;

  @Override
  public ResponseEntity<Void> usersDelete(String id) {
    deleteUserUseCase.execute(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<UsersGet200ResponseDto> usersGet(String id) {
    // TODO Auto-generated method stub
    return UsersApiDelegate.super.usersGet(id);
  }

  @Override
  public ResponseEntity<UsersList200ResponseDto> usersList() {
    var entities = this.listUserUseCase.execute();
    var data =
        entities.stream()
            .map(
                entity -> {
                  var response =
                      UsersList200ResponseDataInnerDto.builder()
                          .username(entity.getUsername())
                          .build();
                  return response;
                })
            .toList();

    var respoonse = UsersList200ResponseDto.builder().data(data).build();
    return ResponseEntity.ok(respoonse);
  }

  @Override
  public ResponseEntity<Void> usersPatch(String id, UserDto user) {
    // TODO Auto-generated method stub
    return UsersApiDelegate.super.usersPatch(id, user);
  }

  @Override
  public ResponseEntity<Void> usersPost(UsersPostRequestDto dto) {
    var model =
        User.builder()
            .name(dto.getName())
            .username(dto.getUsername())
            .password(dto.getPassword())
            .email(dto.getEmail())
            .bio(dto.getBio())
            .image(dto.getImage())
            .build();

    var username = createUserUseCase.execute(model);

    return ResponseEntity.created(URI.create("/users/" + username)).build();
  }
}
