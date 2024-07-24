package personalspring.infrastructure.delegators;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.infrastructure.api.ArticlesApiDelegate;
import personalspring.infrastructure.dto.ArticleDto;
import personalspring.infrastructure.dto.ArticlesList200ResponseDataInnerDto;
import personalspring.infrastructure.dto.ArticlesList200ResponseDto;

@Service
public class ArticlesApiDelegateImpl implements ArticlesApiDelegate {

  @Override
  public ResponseEntity<Void> articlesDelete(String id) {
    // TODO Auto-generated method stub
    return ArticlesApiDelegate.super.articlesDelete(id);
  }

  @Override
  public ResponseEntity<List<ArticlesList200ResponseDataInnerDto>> articlesGet(String id) {
    // TODO Auto-generated method stub
    return ArticlesApiDelegate.super.articlesGet(id);
  }

  @Override
  public ResponseEntity<ArticlesList200ResponseDto> articlesList() {
    // TODO Auto-generated method stub
    return ArticlesApiDelegate.super.articlesList();
  }

  @Override
  public ResponseEntity<Void> articlesPatch(String id) {
    // TODO Auto-generated method stub
    return ArticlesApiDelegate.super.articlesPatch(id);
  }

  @Override
  public ResponseEntity<Void> articlesPost(ArticleDto article) {
    // TODO Auto-generated method stub
    return ArticlesApiDelegate.super.articlesPost(article);
  }
}
