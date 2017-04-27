
package fi.fubar.bibtex.domain;

import java.util.Set;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class UserAccount extends AbstractPersistable<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    
    @OneToMany
    @JoinTable(name = "user_account_articles", joinColumns = {@JoinColumn(name = "user_account_id")}, inverseJoinColumns = {@JoinColumn(name = "article_id")})
    private Set<Article> articles;
    
    @OneToMany
    @JoinTable(name = "user_account_books", joinColumns = {@JoinColumn(name = "user_account_id")}, inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> books;
    
    @OneToMany
    @JoinTable(name = "user_account_inproceedingses", joinColumns = {@JoinColumn(name = "user_account_id")}, inverseJoinColumns = {@JoinColumn(name = "inproceedings_id")})
    private Set<InProceedings> inproceedingses;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
//    @OneToMany WTF Annotaatiot eivät voi olla sekä kenttien että metodien päällä, etpäs tiennyt tätä!
//    @JoinTable(name = "user_account_articles", joinColumns = {@JoinColumn(name = "user_account_id")}, inverseJoinColumns = {@JoinColumn(name = "article_id")})
    public Set<Article> getArticles(){
       return articles; 
    }
    
    public Set<Book> getBooks(){
       return books; 
    }
    
    public Set<InProceedings> getInProceedingses(){
       return inproceedingses; 
    }
}
