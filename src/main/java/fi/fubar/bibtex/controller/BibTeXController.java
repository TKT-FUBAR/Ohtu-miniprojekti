package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.service.ReferenceService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BibTeXController {
    //MediaTypen määrittely on ilmeisesti turhaa
    //private MediaType bibtex = new MediaType("application/x-bibtex");
    
    @Autowired
    private ReferenceService referenceService;
    
    //viinakin on parasta raakana.
    @RequestMapping(produces = "application/x-bibtex", value = "/bibtex", method = RequestMethod.GET)
    @ResponseBody
    public String listInBibTex(Model model, HttpServletResponse response) {
        //model.addAttribute("bibTeXreferences", referenceService.returnAllinBibTeXStrings());
        response.addHeader("Content-disposition", "attachment; filename=\"references.bib\"");
        return referenceService.returnAllinBibTeXStrings();
    }
    
}