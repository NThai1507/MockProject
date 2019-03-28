/*
{C} Copyright 2018 Fresher Academy.
*/

package fa.appcode.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fa.appcode.dao.UserDaoImpl;
import fa.appcode.entities.Users;

@RunWith(MockitoJUnitRunner.class)
public class UserTestServices {

  @InjectMocks
  private UserServicesImpl userServicesImpl;

  @Mock
  private UserDaoImpl userDao;

  @Test
  public void loginTestSuccess() throws Exception {
    when(userDao.isLogin("HaiNT53")).thenReturn(true);
    assertTrue(userServicesImpl.isLogin("HaiNT53"));

  }

  @Test
  public void loginTestFail() throws Exception {
    when(userDao.isLogin("HaiNT53")).thenReturn(false);
    assertFalse(userServicesImpl.isLogin("HaiNT53"));

  }

  @Test
  public void getUserByNameSuccess() throws Exception {
    Users userTest1 = new Users();
    userTest1.setUsersName("HaiNT53");
    userTest1.setPasswords("123456");
    when(userDao.login(userTest1)).thenReturn(userTest1);
    assertEquals(userServicesImpl.login(userTest1).getUsersName(),
        userTest1.getUsersName());

  }

}
