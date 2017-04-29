package fi.fubar.bibtex.service;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.Book;
import fi.fubar.bibtex.domain.InProceedings;
import fi.fubar.bibtex.domain.Reference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ImportBibTexService {

    @Autowired
    private ReferenceService referenceService;
    @Autowired
    private UserService userService;

    public void importBibTex(String bibtex) {
        Reference ref = getRefType(bibtex);
        if (ref != null) {
            parseData(ref, bibtex);
            ref.setOwner(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
            referenceService.save(ref);
        }
    }

    private Reference getRefType(String data) {
        Pattern p = Pattern.compile("(?<=\\@)(.*?)(?=\\{)");
        Matcher m = p.matcher(data);
        if (m.find()) {
            String type = m.group(1).toLowerCase();
            switch (type) {
                case "book":
                    return new Book();
                case "article":
                    return new Article();
                case "inproceedings":
                    return new InProceedings();
                default:
                    return null;
            }
        }
        return null;
    }

    private void parseData(Reference ref, String data) {
        String[] split = data.split("\n");
        //parse fields that are in all references
        ref.setHandle(parseHandle(split[0]));
        String title = parseField("title", split);
        if (title.isEmpty()) {
            title = "default";
        }
        ref.setTitle(title);
        ref.setYear(parseField("year", split));
        ref.setAuthor(parseField("author", split));
        ref.setNumber(parseField("number", split));
        ref.setVolume(parseField("volume", split));
        ref.setMonth(parseField("month", split));
        ref.setPublisher(parseField("publisher", split));
        ref.setNote(parseField("note", split));
        //parse reference specific fields
        switch (ref.getType()) {
            case "book":
                parseBookData((Book) ref, split);
                break;
            case "article":
                parseArticleData((Article) ref, split);
                break;
            case "inproceedings":
                parseInproceedingsData((InProceedings) ref, split);
                break;
        }
    }

    private void parseBookData(Book ref, String[] split) {
        ref.setSeries(parseField("series", split));
        ref.setAddress(parseField("address", split));
    }

    private void parseArticleData(Article ref, String[] split) {
        ref.setJournal(parseField("journal", split));
        ref.setPages(parseField("pages", split));
    }

    private void parseInproceedingsData(InProceedings ref, String[] split) {
        ref.setBooktitle(parseField("booktitle", split));
        ref.setEditor(parseField("editor", split));
        ref.setSeries(parseField("series", split));
        ref.setPages(parseField("pages", split));
        ref.setAddress(parseField("address", split));
        ref.setOrganization(parseField("organization", split));
    }

    private String parseField(String field, String[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].contains(field + " = {")) {
                Pattern p = Pattern.compile("(?<=\\{)(.*?)(?=\\})");
                Matcher m = p.matcher(data[i]);
                if (m.find()) {
                    return m.group(1);
                }
            }
        }
        return "";
    }

    private String parseHandle(String handle) {
        Pattern p = Pattern.compile("(?<=\\{)(.*?)(?=,)");
        Matcher m = p.matcher(handle);
        if (m.find()) {
            return m.group(1);
        } else {
            return "default";
        }
    }
}
