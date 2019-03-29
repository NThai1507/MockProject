package fa.appcode.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.appcode.entities.Class;

@SuppressWarnings("rawtypes")
@Repository
public class ClassDaoImpl<E> implements ClassDao {
  @Autowired
  SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  @Transactional
  @Override
  public List<Class> getAllClass() throws Exception {
    Session session = null;
    List<Class> classes = null;
    try {
      session = getSession();
      classes = new ArrayList<>();
      Query query = session.createQuery("FROM Class");
      classes = query.list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception();
    }
    return classes;
  }

  @Transactional
  @SuppressWarnings({ "unchecked" })
  @Override
  public List<E> classByType() throws Exception {
    Session session = getSession();
    List<E> classToSearchs = null;
    try {
      Query query = session.createQuery(
          "Select subjectType,status,SUM(plannedTraineeNumber)"
          + " as planOfEnrolment  FROM Class GROUP BY status,subjectType");
      classToSearchs = new ArrayList<>(query.list());
    } catch (Exception e) {
      throw new Exception();
    }
    return classToSearchs;
  }

  
  /**
   * this is method is get class by location.
   * 
   * @return 
   */
  @SuppressWarnings("unchecked")
  @Transactional
  public List<E> classByTypeAndLocation() throws Exception {
    Session session = getSession();
    List<E> classToSearchs = null;
    try {
      Query query = session.createQuery(
          "select subjectType,status,SUM(plannedTraineeNumber) "
          + ",location.locationId FROM Class GROUP BY subjectType,"
          + "status, location.locationId ");
      classToSearchs = new ArrayList<>(query.list());
    } catch (Exception e) {
      throw new Exception();
    }
    return classToSearchs;
  }

}
