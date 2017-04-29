package fi.fubar.bibtex.service;

import fi.fubar.bibtex.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ImportAcmService {
    
    @Autowired
    private ImportBibTexService importBibTexService;

    public void importAcm(String url) {
        String data = WebUtils.getACMData(url);
        if (data != null) importBibTexService.importBibTex(data);
    }
}
