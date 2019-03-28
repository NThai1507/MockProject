package fa.appcode.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fa.appcode.entities.Candidate;
import fa.appcode.entities.CandidateProfile;


@ContextConfiguration(locations = { "classpath:dispatcherSetvlet-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CandidateDaoTest {

  @Autowired
  private CandidateDaoo candidateDao;


  
  @Test
  @Transactional
  @Rollback(true)
  public void saveCandidateSuccess() throws Exception {
    Candidate candidate = new Candidate();
    CandidateProfile profile = new CandidateProfile();
    profile.setGender("0");
    candidate.setCandidateProfile(profile);
    candidate.getCandidateProfile().setFullName("Tran Minh");
    assertTrue(candidateDao.save(candidate));
  }
  
  
  @Test
  @Transactional
  @Rollback(true)
  public void saveCandidateFail() throws Exception {
    Candidate candidate = new Candidate();
    CandidateProfile profile = new CandidateProfile();
    profile.setGender("0");
    candidate.setCandidateProfile(profile);
    candidate.getCandidateProfile().setFullName("Tran Minh");
    candidate.setCandidateId(0);
    assertFalse(candidateDao.save(candidate));
  }
}
