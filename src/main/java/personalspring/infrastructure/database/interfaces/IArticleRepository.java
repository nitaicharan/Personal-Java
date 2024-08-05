package personalspring.infrastructure.database.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import personalspring.infrastructure.database.entities.ArticleEntity;

public interface IArticleRepository extends JpaRepository<ArticleEntity, UUID> {}
