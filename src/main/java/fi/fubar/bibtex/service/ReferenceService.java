package fi.fubar.bibtex.service;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.Book;
import fi.fubar.bibtex.domain.InProceedings;
import fi.fubar.bibtex.domain.Reference;
import fi.fubar.bibtex.domain.UserAccount;
import fi.fubar.bibtex.repository.ReferenceRepository;
import fi.fubar.bibtex.repository.ArticleRepository;
import fi.fubar.bibtex.repository.BookRepository;
import fi.fubar.bibtex.repository.InProceedingsRepository;
import fi.fubar.bibtex.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserRepository userRepository;

    private ReferenceRepository[] referenceRepositories() {
        return new ReferenceRepository[]{
            bookRepository, articleRepository, inproceedingsRepository
        };
    }

    public List<Reference> findAll() {

        List<Reference> references = new ArrayList();
        for (ReferenceRepository repository : referenceRepositories()) {
            references.addAll(repository.findAll());
        }
        return references;
    }

    public List<Reference> findAllByUser(UserAccount user) {
        List<Reference> references = new ArrayList();
        if (user == null) {
            return references; // Abandon ship!
        }
        for (ReferenceRepository repository : referenceRepositories()) {
            references.addAll(repository.findAllByOwner(user));
        }
        return references;
    }

    public Reference findByTypeAndId(String type, Long id) {
        switch (type) {
            case "book":
                return bookRepository.findOne(id);
            case "article":
                return articleRepository.findOne(id);
            case "inproceedings":
                return inproceedingsRepository.findOne(id);
            default:
                return null;
        }
    }

    public void save(Reference ref) {
        switch (ref.getType()) {
            case "book":
                bookRepository.save((Book) ref);
                break;
            case "article":
                articleRepository.save((Article) ref);
                break;
            case "inproceedings":
                inproceedingsRepository.save((InProceedings) ref);
                break;
            default:
                break;
        }
    }

    public String returnAllUsersReferencesInBibTeXStrings() {
        UserAccount user = userRepository.findByUsername(securityService.findLoggedInUsername());
        if (user == null) {
            return "";
        }
        List<Reference> references = findAllByUser(user);
        String s = "";
        for (Reference r : references) {
            s += r.toBibTex() + "\n";
        }
        return s;
    }

    public List<Reference> search(String search) {
        List<Reference> found = new ArrayList();
        for (ReferenceRepository repository : referenceRepositories()) {
            found.addAll(repository.searchAllColumns(search));
        }
        return found;
    }
}
