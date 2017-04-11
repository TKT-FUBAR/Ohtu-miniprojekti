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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BibTeXController {
    //MediaTypen määrittely on ilmeisesti turhaa
    //private MediaType bibtex = new MediaType("application/x-bibtex");
    
    @Autowired
    private ReferenceService referenceService;
    
    @RequestMapping(value = "/bibtex", method = RequestMethod.GET)
    public String bibTexPage(){
        return "bibtex";
    }
    
    @RequestMapping(value = "/getbibtex", method = RequestMethod.POST)
    @ResponseBody
    public String listInBibTex(@RequestParam String filename, HttpServletResponse response) {
        
        response.addHeader("Content-disposition", "attachment; filename=\""+filename+".bib\"");
        return referenceService.returnAllinBibTeXStrings();
    }
    
}