package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    @Autowired
    private ReferenceService referenceService;

    @RequestMapping("/")
    public String redirectHome() {
        return "redirect:/references";
    }
    
    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("references", referenceService.findAll());
        return "index";
    }
    
    @RequestMapping(value = "/references/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "add-reference";
    }
}
