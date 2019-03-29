package fa.appcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.dao.UserDao;
import fa.appcode.entities.Users;

@Service
public class UserServicesImpl implements UserServices {
  @Autowired
  UserDao userDao;

  @Override
  public Users loginSv(Users users) throws Exception {
    String username = null;
    try {
      username = users.getUsersName();
      System.out.println(username);
    } catch (Exception e) {
      System.out.println("UserServices: User null");
    }
    return userDao.login(username);
  }

  @Override
  public Users login(Users users) throws Exception {

    return userDao.login(users);
  }

  @Override
  public boolean isLogin(String username) {
    return userDao.isLogin(username);
  }

}
