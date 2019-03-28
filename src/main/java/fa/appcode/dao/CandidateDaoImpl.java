package fa.appcode.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import fa.appcode.common.valueobjects.CandidateInformationVo;
import fa.appcode.common.valueobjects.Counter;
import fa.appcode.entities.Candidate;
import fa.appcode.entities.Channel;
import fa.appcode.entities.EntryTest;
import fa.appcode.entities.Faculty;
import fa.appcode.entities.History;
import fa.appcode.entities.Interview;
import fa.appcode.entities.Location;
import fa.appcode.entities.University;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CandidateDaoImpl implements CandidateDao {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public List<Candidate> lists() {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Candidate> criteriaQuery = builder.createQuery(Candidate.class);
		Root<Candidate> root = criteriaQuery.from(Candidate.class);
		criteriaQuery.select(root);
		Query<Candidate> query = getSession().createQuery(criteriaQuery);

		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean save(Candidate candidate) {
		getSession().save(candidate);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Candidate candidate) {
		getSession().update(candidate);

		if (candidate.getInterviews() != null) {
			for (Interview interview : candidate.getInterviews()) {
				interview.setCandidate(candidate);
//      getSession().update(interview);
			}
		}

		if (candidate.getEntryTests() != null) {
			for (EntryTest entryTest : candidate.getEntryTests()) {
				entryTest.setCandidate(candidate);
//				getSession().update(entryTest);
			}
		}
		
		if (candidate.getHistories() != null) {
			for(History history : candidate.getHistories()) {
				history.setCandidate(candidate);
			}
		}

		return true;
	}

	/**
	 * this is method is view interview result.
	 * 
	 * @param interview interviewResult.
	 * @return status
	 */
	@Transactional
	public boolean deleteInterview(Interview interview) {

		getSession().delete(interview);
		return true;
	}

	/**
	 * this is method is view entry test result.
	 * 
	 * @param entryTest testResult.
	 * @return
	 */
	@Transactional
	public boolean deleteEntryTest(EntryTest entryTest) {

		getSession().delete(entryTest);
		return true;
	}

	@Override
	@Transactional
	public Candidate findByIdCandidate(int id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Candidate> criteriaQuery = builder.createQuery(Candidate.class);
		Root<Candidate> root = criteriaQuery.from(Candidate.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("candidateId"), id));
		Query<Candidate> query = getSession().createQuery(criteriaQuery);
		System.out.println(query.getSingleResult());
		return query.getSingleResult();
	}

	/**
	 * this is method is get all location.
	 * 
	 * @return list all location.
	 */
	@Transactional
	public List<Location> listAllLocation() {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Location> criteriaQuery = builder.createQuery(Location.class);
		Root<Location> root = criteriaQuery.from(Location.class);
		criteriaQuery.select(root);
		Query<Location> query = getSession().createQuery(criteriaQuery);

		// query.setFirstResult((page - 1) * 5);
		// query.setMaxResults(5);
		return query.getResultList();
	}

	/**
	 * this is method is get all University.
	 * 
	 * @return
	 */
	@Transactional
	public List<University> listAllUniversity() {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<University> criteriaQuery = builder.createQuery(University.class);
		Root<University> root = criteriaQuery.from(University.class);
		criteriaQuery.select(root);
		Query<University> query = getSession().createQuery(criteriaQuery);

		// query.setFirstResult((page - 1) * 5);
		// query.setMaxResults(5);
		return query.getResultList();
	}

	/**
	 * this is method is get all Faculty.
	 * 
	 * @return
	 */
	@Transactional
	public List<Faculty> listAllFaculty() {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Faculty> criteriaQuery = builder.createQuery(Faculty.class);
		Root<Faculty> root = criteriaQuery.from(Faculty.class);
		criteriaQuery.select(root);
		Query<Faculty> query = getSession().createQuery(criteriaQuery);

		// query.setFirstResult((page - 1) * 5);
		// query.setMaxResults(5);
		return query.getResultList();
	}

	/**
	 * this is method is get all Channel.
	 * 
	 * @return
	 */
	@Transactional
	public List<Channel> listAllChannel() {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Channel> criteriaQuery = builder.createQuery(Channel.class);
		Root<Channel> root = criteriaQuery.from(Channel.class);
		criteriaQuery.select(root);
		Query<Channel> query = getSession().createQuery(criteriaQuery);

		// query.setFirstResult((page - 1) * 5);
		// query.setMaxResults(5);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<CandidateInformationVo> findByPage(CandidateInformationVo candidateInformationVo, int page,
			int pageSizeResult, Counter counter) throws Exception {
		Session session = getSession();
		System.out.println(page + "--" + pageSizeResult);
		List<CandidateInformationVo> candidateInformationVos = null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CandidateInformationVo> query = builder.createQuery(CandidateInformationVo.class);
			Root<Candidate> root = query.from(Candidate.class);
			List<Predicate> listPredicate = new ArrayList<>();

			root.join("candidateProfile", JoinType.INNER);
			query.select(builder.construct(CandidateInformationVo.class, root.get("candidateId"),
					root.get("candidateProfile").get("fullName"), root.get("candidateProfile").get("account"),
					root.get("candidateProfile").get("dateOfBirth"), root.get("candidateProfile").get("gender"),
					root.get("candidateProfile").get("university"), root.get("candidateProfile").get("faculty"),
					root.get("candidateProfile").get("phone"), root.get("candidateProfile").get("email"),
					root.get("status")));

			if (candidateInformationVo != null) {
				@SuppressWarnings("unused")
				int candidateId = candidateInformationVo.getCandidateId();
				String account = candidateInformationVo.getAccount();
				String fullName = candidateInformationVo.getFullName();
				Date dateOfBirth = candidateInformationVo.getDateOfBirth();

				if ((account != null) && (account != "")) {
					listPredicate.add(builder.like(root.get("candidateProfile").get("account"), "%" + account + "%"));
				}
				if ((fullName != null) && (fullName != "")) {
					listPredicate.add(builder.like(root.get("candidateProfile").get("fullName"), "%" + fullName + "%"));
				}

				if (dateOfBirth != null) {
					listPredicate.add(builder.equal(root.get("candidateProfile").get("dateOfBirth"), dateOfBirth));
				}
				String phone = candidateInformationVo.getPhone();
				if ((phone != null) && (phone != "")) {
					listPredicate.add(builder.like(root.get("candidateProfile").get("phone"), "%" + phone + "%"));
				}
				String email = candidateInformationVo.getEmail();
				if ((email != null) && (email != "")) {
					listPredicate.add(builder.like(root.get("candidateProfile").get("email"), "%" + email + "%"));
				}

			}

			query.where(builder.and(listPredicate.toArray(new Predicate[] {})));

			TypedQuery<CandidateInformationVo> typedQuery = session.createQuery(query);

			Long countTotal = (long) typedQuery.getResultList().size();
			counter.setCountTotal(countTotal);

			typedQuery.setFirstResult((page - 1) * pageSizeResult);

			typedQuery.setMaxResults(pageSizeResult);

			candidateInformationVos = typedQuery.getResultList();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return candidateInformationVos;

	}

	@Transactional
	public University saveUniversity(University university) {
		getSession().save(university);
		return university;
	}

	@Transactional
	public Faculty saveFaculty(Faculty faculty) {
		getSession().save(faculty);
		return faculty;
	}

}
