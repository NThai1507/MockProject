package fa.appcode.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.appcode.entities.History;

@Transactional
@Repository
public class HistoryDaoImpl implements HistoryDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<History> getAllHistory() {
    Session session = sessionFactory.openSession();
    @SuppressWarnings("rawtypes")
    Query query = session.createQuery("From History");
    @SuppressWarnings("unchecked")
    List<History> histories = query.list();
    return histories;
  }

  @Override
  public void saveHistory(History history) {
    Session session = sessionFactory.openSession();
    try {
      session.save(history);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
