
package fi.fubar.bibtex.service;

import fi.fubar.bibtex.domain.Reference;
import fi.fubar.bibtex.repository.ArticleRepository;
import fi.fubar.bibtex.repository.BookRepository;
import fi.fubar.bibtex.repository.InProceedingsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for querying the different reference types.
 */
@Service
public class ReferenceService {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InProceedingsRepository inproceedingsRepository;
    
    public List<Reference> findAll() {
        List<Reference> references = new ArrayList<>();
        references.addAll(bookRepository.findAll());
        references.addAll(articleRepository.findAll());
        references.addAll(inproceedingsRepository.findAll());
        
        return references;
    }
}
