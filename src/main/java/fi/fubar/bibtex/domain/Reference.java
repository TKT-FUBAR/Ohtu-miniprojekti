
package fi.fubar.bibtex.domain;

public interface Reference {
    public String toBibTex();
    public String getType();
    public String getTitle();
    public String getHandle();
    public String getCreator();
    public Long getId();
    public void setTitle(String title);
    public void setAuthor(String author);
    public void setYear(String year);
    public void setHandle(String handle);
    public void setNote(String note);
    public void setMonth(String month);
    public void setNumber(String number);
    public void setPublisher(String publisher);
    public void setVolume(String volume);
}
