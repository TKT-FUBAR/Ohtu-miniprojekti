
package fi.fubar.bibtex.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount extends AbstractPersistable<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String name) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
