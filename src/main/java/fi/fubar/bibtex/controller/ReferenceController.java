package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Reference;
import fi.fubar.bibtex.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReferenceController {

    @Autowired
    private ReferenceService referenceService;

    @RequestMapping(value = "/references/{type}/edit/{id}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable String type, @PathVariable Long id) {
        Reference ref = referenceService.findByTypeAndId(type, id);
        if (ref != null) {
            model.addAttribute("reference", ref);
            return "edit-" + type;
        } else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/references/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "add-reference";
    }

}
