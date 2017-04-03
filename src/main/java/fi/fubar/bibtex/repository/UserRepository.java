
package fi.fubar.bibtex.repository;

import fi.fubar.bibtex.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

}


