package fa.appcode.dao;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.appcode.entities.Candidate;
import fa.appcode.entities.EntryTest;
import fa.appcode.entities.History;
import fa.appcode.entities.Interview;

@SuppressWarnings("unused")
@Repository
public class CandidateDaoImpll implements CandidateDaoo {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean save(Candidate candidate) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		session.save(candidate);
		if (candidate.getEntryTests() != null) {
			for (EntryTest entryTest : candidate.getEntryTests()) {
				entryTest.setCandidate(candidate);
			}
		}
		if (candidate.getInterviews() != null) {
			for (Interview interview : candidate.getInterviews()) {
				interview.setCandidate(candidate);
			}
		}
		if (candidate.getHistories() != null) {
        for(History history : candidate.getHistories()){
      history.setCandidate(candidate);
    
    }
		}

		return true;
	}

}
