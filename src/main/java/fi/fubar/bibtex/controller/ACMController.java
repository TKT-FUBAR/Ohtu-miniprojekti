package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.service.ACMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ACMController {

    @Autowired
    private ACMService ACMService;

    @RequestMapping(value = "/acm", method = RequestMethod.GET)
    public String acmPage() {
        return "acm";
    }

    @RequestMapping(value = "/getACM", method = RequestMethod.POST)
    public String listInBibTex(@RequestParam String url) {
        ACMService.importAcm(url);
        return "redirect:/";
    }

}
