package fi.fubar.bibtex.domain;

import fi.fubar.bibtex.util.StringUtils;
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
    public String getType() {
        return "inproceedings";
    }
    
    @Override
    public String toString() {
        return "InProceedings: " + author + ". " + title;
    }

    @Override
    public String toBibTex() {
        StringBuilder sb = new StringBuilder("@inproceedings{");
        sb.append(StringUtils.actualOrDefault(handle));
        sb.append(",\nauthor = {").append(StringUtils.actualOrDefault(author)).append("}");
        sb.append(",\ntitle = {").append(StringUtils.actualOrDefault(title)).append("}");
        sb.append(",\nbooktitle = {").append(StringUtils.actualOrDefault(booktitle)).append("}");
        sb.append(",\nyear = {").append(StringUtils.actualOrDefault(year)).append("}");
        StringUtils.optional(sb, "editor", editor);
        StringUtils.optional(sb, "volume", volume);
        StringUtils.optional(sb, "number", number);
        StringUtils.optional(sb, "series", series);
        StringUtils.optional(sb, "pages", pages);
        StringUtils.optional(sb, "address", address);
        StringUtils.optional(sb, "month", month);
        StringUtils.optional(sb, "organization", organization);
        StringUtils.optional(sb, "publisher", publisher);
        StringUtils.optional(sb, "note", note);
        sb.append("\n}");
        return StringUtils.escapeScandics(sb.toString());
    }

    @Override
    public String getCreator() {
        return author;
    }
    
}
