/*
{C} Copyright 2018 Fresher Academy.
*/

package fa.appcode.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.appcode.entities.Users;

@Repository
public class UserDaoImpl implements UserDao {
  @Autowired
  SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }


  /**
   * this is method is check user.
   * 
   * @return 
   */
  public Users login(Users users) {
    Users userResult = null;
    List<Users> userss = new ArrayList<>();
    Session session = null;
    session = getSession();
    @SuppressWarnings("unchecked")
    Query<Users> query = session
        .createQuery("FROM Users where usersName=:userName");
    query.setParameter("userName", users.getUsersName());
    /*
     * query.setParameter("password",users.getPasswords()); AND
     * passwords=:password
     */
    userss = query.list();
    if (userss.size() > 0) {
      userResult = userss.get(0);
    }
    return userResult;
  }

  @SuppressWarnings("unchecked")
  @Override
  @Transactional
  public Users login(String userName) {
    List<Users> userss = new ArrayList<>();
    Session session = getSession();
    @SuppressWarnings("rawtypes")
    Query query = session.createQuery("FROM Users where usersName=:userName");
    query.setParameter("userName", userName);
    userss = query.list();
    if (userss.size() > 0) {
      Users userResult = userss.get(0);
      return userResult;
    }
    return null;
  }

  /**
   * this is method is check user by name.
   * 
   * @return 
   */
  @Override
  public Boolean isLogin(String userName) {
    Session session = getSession();
    @SuppressWarnings("rawtypes")
    Query query = session.createQuery("FROM Users where usersName=:userName");
    query.setParameter("userName", userName);
    try {
      @SuppressWarnings("unused")
      Users userResult = (Users) query.list().get(0);
      return true;
    } catch (Exception e) {
      return false;
    }

  }

}
