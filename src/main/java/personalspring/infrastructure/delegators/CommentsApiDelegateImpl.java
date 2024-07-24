package personalspring.infrastructure.delegators;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.infrastructure.api.CommentsApiDelegate;
import personalspring.infrastructure.dto.CommentDto;
import personalspring.infrastructure.dto.CommentsList200ResponseDto;

@Service
@AllArgsConstructor
public class CommentsApiDelegateImpl implements CommentsApiDelegate {
  @Override
  public ResponseEntity<CommentsList200ResponseDto> commentsList() {
    // TODO Auto-generated method stub
    return CommentsApiDelegate.super.commentsList();
  }

  @Override
  public ResponseEntity<Void> commentsPost(CommentDto comment) {
    // TODO Auto-generated method stub
    return CommentsApiDelegate.super.commentsPost(comment);
  }
}
