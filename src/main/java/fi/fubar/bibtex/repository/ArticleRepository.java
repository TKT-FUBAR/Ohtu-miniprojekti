package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
