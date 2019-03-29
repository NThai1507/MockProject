package fa.appcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import fa.appcode.dao.UserDao;
import fa.appcode.entities.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserDao userDao;

  /**
   * this method to Spring security.
   * 
   * @return
   */
  public UserDetails loadUserByUsername(final String username) {
    Users users = userDao.login(username);
    if (users == null) {
      return null;
    }
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    return new User(username, users.getPasswords(), enabled, accountNonExpired,
        credentialsNonExpired, accountNonLocked, users.getRole().getRoleName());

  }

}
