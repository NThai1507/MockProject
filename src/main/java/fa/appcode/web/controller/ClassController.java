package fa.appcode.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fa.appcode.service.ClassServices;

@RestController
public class ClassController<E> {
  @Autowired
  ClassServices<?> classServices;

  /**
   * this is method is controller.
   * 
   * @return
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/getClass", method = RequestMethod.POST)
  public List<E> getAllClass() {
    List<E> classes = null;
    try {
      classes = new ArrayList<>();
      classes = (List<E>) classServices.getAllClassByType();

    } catch (Exception e) {
      System.out.println(e);
    }
    return classes;
  }

  /**
   * this is method is controller.
   * 
   * @return
   */
  @SuppressWarnings("unchecked")
  @PostMapping("/getClassByLocation")
  public List<E> getAllClassBuLocation() {
    List<E> classByLocation = null;
    try {
      classByLocation = new ArrayList<>();
      classByLocation = (List<E>) classServices.getAllClassByLocation();

    } catch (Exception e) {
      System.out.println(e);
    }
    return classByLocation;
  }

}
