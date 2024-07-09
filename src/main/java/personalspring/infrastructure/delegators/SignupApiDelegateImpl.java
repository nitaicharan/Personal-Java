package personalspring.infrastructure.delegators;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import personalspring.infrastructure.api.SignupApiDelegate;
import personalspring.infrastructure.dto.SignUp;

@Service
public class SignupApiDelegateImpl implements SignupApiDelegate {

  @Override
  public ResponseEntity<Void> postSignup(SignUp signUp) {
    return SignupApiDelegate.super.postSignup(signUp);
  }
}
