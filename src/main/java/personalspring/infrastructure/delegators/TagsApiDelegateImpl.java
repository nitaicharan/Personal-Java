package personalspring.infrastructure.delegators;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.infrastructure.api.TagsApiDelegate;

@Service
public class TagsApiDelegateImpl implements TagsApiDelegate {

  @Override
  public ResponseEntity<List<String>> tagsList() {
    // TODO Auto-generated method stub
    return TagsApiDelegate.super.tagsList();
  }
}
