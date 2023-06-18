package personalspring.infrastructure.database.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import personalspring.infrastructure.database.entities.ArticleEntity;

public interface IArticlePersister extends JpaRepository<ArticleEntity, UUID> {
    public Optional<ArticleEntity> findBySlug(String slug);
}
