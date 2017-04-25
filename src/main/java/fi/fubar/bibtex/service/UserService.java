/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.fubar.bibtex.service;
import fi.fubar.bibtex.domain.UserAccount;
/**
 *
 * @author psmaatta
 */
public interface UserService {
    void save(UserAccount user);

    UserAccount findByUsername(String username);
}
