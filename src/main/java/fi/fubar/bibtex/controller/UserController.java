
package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    private List<String> userdb;

    public UserController() {
        userdb = new ArrayList<>();
        userdb.add("foo,bar");
    }
    
    @RequestMapping(value = "/createuser")
    public String home(Model model) {
        model.addAttribute("userdb", userdb);
        return "createuser";
    }
    
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String add(String tunnus, String salasana) {
        userdb.add(tunnus + "," + salasana);
        return "redirect:/createuser";
    }
}
