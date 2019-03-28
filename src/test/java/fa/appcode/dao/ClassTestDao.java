package fa.appcode.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fa.appcode.entities.Class;
import fa.appcode.service.ClassServices;

@ContextConfiguration(locations = { "classpath:dispatcherSetvlet-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ClassTestDao {
  @SuppressWarnings("rawtypes")
  @Autowired
  ClassDao classDao;
  @Autowired
  SessionFactory sessionFactory;
  @SuppressWarnings("rawtypes")
  @Autowired
  ClassServices classServices;

  @SuppressWarnings("unchecked")
  @Test
  @Transactional
  public void getAllSuccess() throws Exception {
    List<Class> results = new ArrayList<>();
    results = classDao.getAllClass();
    @SuppressWarnings("unused")
    Session session = sessionFactory.openSession();
    int sizeTest = classServices.getAllClass().size();
    assertEquals(results.size(), sizeTest);
  }

  @SuppressWarnings("unchecked")
  @Test
  @Transactional
  public void getAllByTypeSuccess() throws Exception {
    List<Class> results = new ArrayList<>();
    results = classDao.classByType();
    @SuppressWarnings("unused")
    Session session = sessionFactory.openSession();
    int sizeTest = classServices.getAllClassByType().size();
    assertEquals(results.size(), sizeTest);
  }

  @SuppressWarnings("unchecked")
  @Test
  @Transactional
  public void getAllByTypeAndLocationSuccess() throws Exception {
    List<Class> results = new ArrayList<>();
    results = classDao.classByTypeAndLocation();
    @SuppressWarnings("unused")
    Session session = sessionFactory.openSession();
    int sizeTest = classServices.getAllClassByLocation().size();
    assertEquals(results.size(), sizeTest);
  }
  
  
 

}
