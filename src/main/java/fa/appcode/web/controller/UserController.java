/*
{C} Copyright 2018 Fresher Academy.
*/

package fa.appcode.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.appcode.entities.Users;
import fa.appcode.service.UserServices;

@RestController
// @RequestMapping("/UserDao")
public class UserController {
  @Autowired
  UserServices userServices;

  /**
   * this is method is controller.
   * 
   * @return
   */
  @PostMapping("/login")
  public boolean login(@RequestBody Users users, HttpSession session) {
    Users userResult = null;
    try {
      System.out.println("POST");
      userResult = userServices.loginSv(users);
      if (userResult != null) {
        session.setAttribute("Role", userResult.getRole().getRoleName());

        return true;
      } else {
        session.setAttribute("err",
            "Sorry, your username or password is incorrect. Please try again!");
        return false;
      }
    } catch (Exception e) {
      session.setAttribute("err",
          "Sorry, your username or password is incorrect. Please try again!");
      return false;
    }
  }

  /**
   * this is method is controller.
   * 
   * @return
   */
  @PostMapping("/loginError")
  public boolean loginErr(@RequestBody String error, HttpSession session) {
    System.out.println(error);
    if (null != error) {
      session.setAttribute("err",
          "Sorry, your username or password is incorrect. Please try again!");
      System.out.println("err");
    } else {
      session.removeAttribute("err");
      System.out.println("else");
    }

    return true;
  }

  /**
   * this is method is controller.
   * 
   * @return
   */
  @PostMapping("/logout")
  public boolean logout(HttpSession session) {
    try {
      session.removeAttribute("Role");
      session.removeAttribute("err");
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
