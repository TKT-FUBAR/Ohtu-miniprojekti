package fi.fubar.bibtex.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article extends AbstractPersistable<Long> implements Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String handle;
    // required
    private String title;
    private String journal;
    private String author;
    private String year;
    // optional
    private String volume; // OR number
    private String number;
    private String pages;
    private String month;
    private String note;

    @ManyToOne
    private UserAccount owner;

    public UserAccount getOwner() {
        return owner;
    }

    public void setOwner(UserAccount owner) {
        this.owner = owner;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public String getTitle() {
        return title;
    }

    public String getJournal() {
        return journal;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public String getMonth() {
        return month;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Article: " + author + ". " + title;
    }

    @Override
    public String toBibTex() {
        return "@article{}";
    }

}
