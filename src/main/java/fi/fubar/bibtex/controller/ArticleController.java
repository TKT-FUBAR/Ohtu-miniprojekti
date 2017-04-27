package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.Reference;
import fi.fubar.bibtex.domain.UserAccount;
import fi.fubar.bibtex.repository.ArticleRepository;
import fi.fubar.bibtex.repository.UserRepository;
import fi.fubar.bibtex.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SecurityService securityService;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Article article) {
        UserAccount user = userRepository.findByUsername(securityService.findLoggedInUsername());
        article.setOwner(user);
        articleRepository.save(article);
        return "redirect:/";
    }
    
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Article article) {
        articleRepository.save(article);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Long id) {
        articleRepository.delete(id);
        return "redirect:/";
    }
}
