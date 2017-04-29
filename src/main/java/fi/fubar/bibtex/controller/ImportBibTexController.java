package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.service.ImportBibTexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImportBibTexController {

    @Autowired
    private ImportBibTexService importBibTexService;

    @RequestMapping(value = "/importBibTex", method = RequestMethod.GET)
    public String acmPage() {
        return "importBibTex";
    }

    @RequestMapping(value = "/importBibTex", method = RequestMethod.POST)
    public String listInBibTex(@RequestParam String bibimport) {
        importBibTexService.importBibTex(bibimport);
        return "redirect:/";
    }

}
