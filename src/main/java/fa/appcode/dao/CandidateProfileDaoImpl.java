package fa.appcode.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.appcode.common.logging.LogFactory;
import fa.appcode.entities.CandidateProfile;

@Repository
@Transactional
public class CandidateProfileDaoImpl implements CandidateProfileDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override

  public boolean save(CandidateProfile candidateProfile)
      throws Exception {
    Session session = sessionFactory.getCurrentSession();
    try {
      session.save(candidateProfile);
      return true;
    } catch (Exception e) {
      e.printStackTrace();

    }
    return false;
  }

  @Override
  public int findCurrentBiggestId() throws Exception {
    Session session = sessionFactory.getCurrentSession();
    @SuppressWarnings("rawtypes")
    Query query = session
        .createQuery("SELECT MAX(C.profileId) FROM CandidateProfile C ");
    int currentBiggestId = 0;
    try {
      currentBiggestId = (int) query.list().get(0);
    } catch (Exception e) {
      LogFactory.getlogger().info(e);
    }

    int newId = currentBiggestId + 1;
    System.out.println(newId);
    return newId;
  }

  @Override
  public int findDuplicateAccount(String account) {
    Session session = sessionFactory.getCurrentSession();
    @SuppressWarnings("rawtypes")
    Query query = session
        .createQuery("FROM CandidateProfile C WHERE C.account like: account  ");
    query.setParameter("account", account + "%");
    int noAccounts = query.list().size();
    return noAccounts;
  }

  /*
   * @Override
   * 
   * @Transactional public CandidateProfile findByProfileId(int id) {
   * CriteriaBuilder builder = sessionFactory.getCurrentSession()
   * .getCriteriaBuilder(); CriteriaQuery<CandidateProfile> criteriaQuery =
   * builder .createQuery(CandidateProfile.class); Root<CandidateProfile> root =
   * criteriaQuery.from(CandidateProfile.class); criteriaQuery.select(root);
   * criteriaQuery.where(builder.equal(root.get("profileId"), id));
   * Query<CandidateProfile> query =
   * sessionFactory.getCurrentSession().createQuery(criteriaQuery);
   * System.out.println(query.getSingleResult()); return
   * query.getSingleResult(); }
   */

}
