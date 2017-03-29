package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
