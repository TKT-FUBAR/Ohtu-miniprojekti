package fi.fubar.bibtex.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InProceedings extends AbstractPersistable<Long> implements Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String handle;
    // required
    private String author;
    private String title;
    private String booktitle;
    private String year;
    // optional
    private String editor;
    private String volume;
    private String number;
    private String series;
    private String pages;
    private String address;
    private String month;
    private String organization;
    private String publisher;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public String getYear() {
        return year;
    }

    public String getEditor() {
        return editor;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getSeries() {
        return series;
    }

    public String getPages() {
        return pages;
    }

    public String getAddress() {
        return address;
    }

    public String getMonth() {
        return month;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "InProceedings: " + author + ". " + title;
    }
}
