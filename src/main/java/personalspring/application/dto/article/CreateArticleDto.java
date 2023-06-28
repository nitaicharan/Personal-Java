package personalspring.application.dto.article;
import jakarta.validation.constraints.NotNull;
import personalspring.domain.models.Article;

public class CreateArticleDto {
    @NotNull
    private String slug;

    public Article toModel(){
        return Article.builder().slug(this.slug).build();
    }
}
