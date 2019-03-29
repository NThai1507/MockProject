package fa.appcode.dao;

import static org.junit.Assert.assertNotNull;


import javax.transaction.Transactional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fa.appcode.entities.Candidate;

/**
 * Test findcandidateById theo CandidateDao
 * @author AnNV16
 *
 */
@ContextConfiguration(locations = { "classpath:dispatcherSetvlet-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class findCandidateByIdTestDao {
@Autowired
private CandidateDao candidateDao;


@Test
@Transactional
public void findByIdCandidate() throws Exception {
int id = 1;
Candidate candidate = new Candidate();
candidate =candidateDao.findByIdCandidate(id);
System.out.println(candidate.getApplicationDate());
assertNotNull(candidate);
}
}