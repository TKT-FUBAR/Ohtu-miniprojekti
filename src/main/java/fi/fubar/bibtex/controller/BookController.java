package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.Book;
import fi.fubar.bibtex.domain.UserAccount;
import fi.fubar.bibtex.repository.BookRepository;
import fi.fubar.bibtex.repository.UserRepository;
import fi.fubar.bibtex.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SecurityService securityService;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        UserAccount user = userRepository.findByUsername(securityService.findLoggedInUsername());
        book.setOwner(user);
        bookRepository.save(book);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Book book) {
        UserAccount user = userRepository.findByUsername(securityService.findLoggedInUsername());
        book.setOwner(user);
        bookRepository.save(book);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Long id) {
        bookRepository.delete(id);
        return "redirect:/";
    }
}
