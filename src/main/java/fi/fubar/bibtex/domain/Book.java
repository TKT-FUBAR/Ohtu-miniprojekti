package fi.fubar.bibtex.domain;

import fi.fubar.bibtex.util.StringUtils;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book extends AbstractPersistable<Long> implements Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String handle;
    // required
    private String title;
    private String author; // author OR editor required
    private String editor; 
    private String publisher; 
    private String year;
    // optional
    private String volume; // OR number
    private String number;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String note;
    
    @ManyToOne
    private UserAccount owner;

    public void setOwner(UserAccount owner) {
        this.owner = owner;
    }

    public UserAccount getOwner() {
        return owner;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public void setSeries(String series) {
        this.series = series;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEdition(String edition) {
        this.edition = edition;
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

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    public String getPublisher() {
        return publisher;
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

    public String getSeries() {
        return series;
    }

    public String getAddress() {
        return address;
    }

    public String getEdition() {
        return edition;
    }

    public String getMonth() {
        return month;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String getType() {
        return "book";
    }
    
    @Override
    public String toString() {
        return "Book: " + author + ". " + title;
    }

    @Override
    public String toBibTex() {
        StringBuilder sb = new StringBuilder("@book{");
        sb.append(StringUtils.actualOrDefault(handle));
        authorOrEditor(sb);
        sb.append(",\ntitle = {").append(StringUtils.actualOrDefault(title)).append("}");
        sb.append(",\npublisher = {").append(StringUtils.actualOrDefault(publisher)).append("}");
        sb.append(",\nyear = {").append(StringUtils.actualOrDefault(year)).append("}");
        StringUtils.optional(sb, "volume", volume);
        StringUtils.optional(sb, "number", number);
        StringUtils.optional(sb, "series", series);
        StringUtils.optional(sb, "address", address);
        StringUtils.optional(sb, "edition", edition);
        StringUtils.optional(sb, "month", month);
        StringUtils.optional(sb, "note", note);
        sb.append("\n}");
        return StringUtils.escapeScandics(sb.toString());
    }

    private void authorOrEditor(StringBuilder sb) {
        if ((author == null || author.isEmpty()) &&
                (editor == null || editor.isEmpty())) {
            sb.append(",\nauthor = {N/A}");
            return;
        } 
        if (author != null && !author.isEmpty()) {
            sb.append(",\nauthor = {").append(author).append("}");
        }
        if (editor != null && !editor.isEmpty()) {
            sb.append(",\neditor = {").append(editor).append("}");
        }
    }
}
