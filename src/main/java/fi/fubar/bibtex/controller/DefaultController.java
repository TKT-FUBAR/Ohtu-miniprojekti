package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Reference;
import fi.fubar.bibtex.repository.ArticleRepository;
import fi.fubar.bibtex.repository.BookRepository;
import fi.fubar.bibtex.repository.InProceedingsRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ArticleRepository articlekRepository;
    @Autowired
    private InProceedingsRepository inProceedingsRepository;

    @RequestMapping("/")
    public String redirectHome() {
        return "redirect:/references";
    }
    
    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String list(Model model) {
        ArrayList<Reference> references = new ArrayList<>();
        references.addAll(bookRepository.findAll());
        references.addAll(articlekRepository.findAll());
        references.addAll(inProceedingsRepository.findAll());
        model.addAttribute("references", references);
        return "index";
    }
}
