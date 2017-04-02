
package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @RequestMapping(value = "/createuser")
    public String home(Model model) {
        model.addAttribute("kayttaja", "Kayttaja");
        return "usercreate";
    }
}
