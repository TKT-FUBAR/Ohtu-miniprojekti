
package fi.fubar.bibtex.domain;

public interface Reference {
    public String toBibTex();
    public String getType();
    public String getTitle();
    public String getHandle();
    public String getCreator();
    public Long getId();
    public UserAccount getOwner();
    public void setOwner(UserAccount owner);
}
