CREATE TABLE articles (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    body TEXT NOT NULL,
    description VARCHAR(255) NOT NULL,
    favorited BOOLEAN NOT NULL DEFAULT FALSE,
    favorites_count INT NOT NULL DEFAULT 0,
    slug VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
