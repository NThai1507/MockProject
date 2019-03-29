package fa.appcode.service;

import fa.appcode.entities.Users;

public interface UserServices {

  Users loginSv(Users users) throws Exception;

  Users login(Users users) throws Exception;

  boolean isLogin(String username);
}
