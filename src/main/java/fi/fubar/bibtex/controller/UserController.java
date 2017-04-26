
package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.repository.UserRepository;
import fi.fubar.bibtex.domain.UserAccount;
import fi.fubar.bibtex.service.SecurityService;
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
    
    @Autowired
    private SecurityService securityService;

    
    @RequestMapping(value = "/createuser")
    public String home(Model model) {
        model.addAttribute("userdb", userRepository.findAll());
        return "createuser";
    }
    
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String add(UserAccount user) {
        userRepository.save(user);
        
        securityService.autologin(user.getUsername(), user.getPassword());

        return "redirect:/references";
    }
}
