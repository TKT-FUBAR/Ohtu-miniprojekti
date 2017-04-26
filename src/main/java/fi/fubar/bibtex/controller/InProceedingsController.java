package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.Book;
import fi.fubar.bibtex.domain.InProceedings;
import fi.fubar.bibtex.repository.InProceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/inproceedings")
public class InProceedingsController {

    @Autowired
    private InProceedingsRepository inProceedingsRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(InProceedings inProceedings) {
        inProceedingsRepository.save(inProceedings);
        return "redirect:/";
    }
    
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute InProceedings in) {
        inProceedingsRepository.save(in);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Long id) {
        inProceedingsRepository.delete(id);
        return "redirect:/";
    }
}
