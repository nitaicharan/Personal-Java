package personalspring.infrastructure.delegators;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.infrastructure.api.SignupApiDelegate;
import personalspring.infrastructure.dto.PostSignupRequestDto;

@Service
public class SignupApiDelegateImpl implements SignupApiDelegate {

  @Override
  public ResponseEntity<Void> postSignup(PostSignupRequestDto postSignupRequest) {
    // TODO Auto-generated method stub
    return SignupApiDelegate.super.postSignup(postSignupRequest);
  }
}
