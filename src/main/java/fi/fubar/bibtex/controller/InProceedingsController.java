package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.InProceedings;
import fi.fubar.bibtex.repository.InProceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}