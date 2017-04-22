package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(CONCAT("
            + "b.title, b.author, b.editor, b.publisher, b.note, b.handle, b.series, b.address, b.edition"
            + ")) LIKE LOWER(CONCAT('%', ?1, '%'))")
    public List<Book> searchAllColumns(String searchString);
}
