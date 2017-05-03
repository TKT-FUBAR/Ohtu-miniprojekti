package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.UserAccount;
import java.util.List;

public interface ReferenceRepository<T> {

    public List<T> searchAllColumns(String searchString);
    
    public List<T> findAllByOwner(UserAccount owner);

    public List<T> findAll();

}