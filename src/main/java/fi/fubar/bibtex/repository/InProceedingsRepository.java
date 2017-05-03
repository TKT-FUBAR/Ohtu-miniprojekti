package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.InProceedings;
import fi.fubar.bibtex.domain.UserAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InProceedingsRepository extends JpaRepository<InProceedings, Long>, ReferenceRepository {

    @Query("SELECT i FROM InProceedings i WHERE LOWER(CONCAT("
            + "i.title, i.author, i.note, i.handle, i.booktitle, i.editor, i.address, i.organization, i.publisher"
            + ")) LIKE LOWER(CONCAT('%', ?1, '%'))")
    public List<InProceedings> searchAllColumns(String searchString);
    
    public List<InProceedings> findAllByOwner(UserAccount owner);
}
