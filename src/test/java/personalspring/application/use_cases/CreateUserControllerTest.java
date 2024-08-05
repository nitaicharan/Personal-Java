package personalspring.application.use_cases.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import personalspring.domain.models.User;
import personalspring.domain.persistenceis.IUserPersistency;

class CreateUserUseCaseTest {

  @Mock private IUserPersistency persistency;

  @InjectMocks private CreateUserUseCase createUserUseCase;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void execute_shouldThrowBadRequest_whenUserAlreadyExists() {
    User mock = mock(User.class);
    when(mock.getEmail()).thenReturn("test@example.com");
    when(mock.getUsername()).thenReturn("testuser");

    when(persistency.findByEmailOrUsername(anyString(), anyString())).thenReturn(List.of(mock));

    ResponseStatusException exception =
        assertThrows(ResponseStatusException.class, () -> createUserUseCase.execute(mock));

    assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    assertEquals("User already exists", exception.getReason());
  }

  @Test
  void execute_shouldReturnCreatedUserIdSuccessfully_whenPassInAllValidations() {
    var expectedId = UUID.randomUUID();

    when(persistency.findByEmailOrUsername(anyString(), anyString())).thenReturn(List.of());

    User mockUserSaved = mock(User.class);
    when(mockUserSaved.getId()).thenReturn(expectedId);
    when(persistency.create(any())).thenReturn(mockUserSaved);

    User mockUserRequest = mock(User.class);
    when(mockUserRequest.getEmail()).thenReturn("test@example.com");
    when(mockUserRequest.getUsername()).thenReturn("testuser");
    var id = createUserUseCase.execute(mockUserRequest);

    assertEquals(expectedId, id);
  }
}
