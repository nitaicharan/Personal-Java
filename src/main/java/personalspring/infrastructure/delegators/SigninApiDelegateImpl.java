package personalspring.infrastructure.delegators;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.infrastructure.api.SigninApiDelegate;
import personalspring.infrastructure.dto.SignInDto;

@Service
public class SigninApiDelegateImpl implements SigninApiDelegate {

  @Override
  public ResponseEntity<Void> postSignin(SignInDto signIn) {
    // TODO Auto-generated method stub
    return SigninApiDelegate.super.postSignin(signIn);
  }
}
