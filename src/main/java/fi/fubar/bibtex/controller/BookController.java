package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Book;
import fi.fubar.bibtex.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}
