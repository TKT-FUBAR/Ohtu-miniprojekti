/*
package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.repository.UserRepository;
import fi.fubar.bibtex.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/createuser")
    public String home(Model model) {
        model.addAttribute("userdb", userRepository.findAll());
        return "createuser";
    }
    
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String add(User user) {
        userRepository.save(user);
        return "redirect:/createuser";
    }
}
*/