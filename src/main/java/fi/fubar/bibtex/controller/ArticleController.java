package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Article article) {
        articleRepository.save(article);
        return "redirect:/";
    }
}
