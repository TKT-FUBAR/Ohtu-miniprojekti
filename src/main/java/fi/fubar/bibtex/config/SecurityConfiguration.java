
package fi.fubar.bibtex.config;

import fi.fubar.bibtex.domain.UserAccount;
import fi.fubar.bibtex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private UserRepository userRepository;

//    public SecurityConfiguration() {
//        
//    }
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF and same-origin headers disabled to enable using H2 console ( http:// ... /h2-console/ )
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        
        http.authorizeRequests()
            .antMatchers("/createuser").permitAll()    
            .anyRequest().authenticated().and()
            .formLogin()
            .permitAll().and()
            .logout().permitAll();
    }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // create foo,bar if not exists
        if (userRepository.findByUsername("foo") == null){
            UserAccount foobar = new UserAccount();
            foobar.setUsername("foo");
            foobar.setPassword("bar");
            userRepository.save(foobar);
        }    
        auth.userDetailsService(userDetailsService);
               // can't combine these two.
//            auth.inMemoryAuthentication()
//                .withUser("foo").password("bar").roles("USER");
    }
}
