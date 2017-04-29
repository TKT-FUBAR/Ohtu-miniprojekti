package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.service.ImportAcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImportAcmController {

    @Autowired
    private ImportAcmService importAcmService;

    @RequestMapping(value = "/importAcm", method = RequestMethod.GET)
    public String acmPage() {
        return "importAcm";
    }

    @RequestMapping(value = "/importAcm", method = RequestMethod.POST)
    public String importAcm(@RequestParam String acmurl) {
        importAcmService.importAcm(acmurl);
        return "redirect:/";
    }

}
