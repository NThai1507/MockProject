/*
{C} Copyright 2018 Fresher Academy.
*/

package fa.appcode.dao;

import fa.appcode.entities.Users;

public interface UserDao {

  Users login(Users users);

  Users login(String userName);

  Boolean isLogin(String userName);
}
