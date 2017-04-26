package fi.fubar.bibtex.service;
import fi.fubar.bibtex.domain.UserAccount;
import fi.fubar.bibtex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserAccount user) {
        userRepository.save(user);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
