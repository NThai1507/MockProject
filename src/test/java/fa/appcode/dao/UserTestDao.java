package fa.appcode.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fa.appcode.entities.Users;

@ContextConfiguration(locations = { "classpath:dispatcherSetvlet-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserTestDao {
  @Autowired
  private UserDao userDao;

  @Test
  @Transactional
  @Rollback(true)
  public void isLoginSuccess() throws Exception {
    boolean result = userDao.isLogin("HaiNt53");
    assertTrue(result);
  }

  @Test
  @Transactional
  @Rollback(true)
  public void isLoginFail() throws Exception {
    boolean result = userDao.isLogin("Test01");
    assertFalse(result);
  }

  @Test
  @Transactional
  @Rollback(true)
  public void loginByNameSuccess() throws Exception {
    Users result = userDao.login("HaiNT53");
    assertEquals("HaiNT53", result.getUsersName());
    ;
  }

  @Test
  @Transactional
  @Rollback(true)
  public void loginByNameFail() throws Exception {
    Users result = userDao.login("Test01");
    assertEquals(null, result);
  }
}
