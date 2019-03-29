package fa.appcode.dao;

import static org.junit.Assert.assertEquals;
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

import fa.appcode.entities.CandidateProfile;
import fa.appcode.service.CandidateProfileService;

@ContextConfiguration(locations = { "classpath:dispatcherSetvlet-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CandidateProfileDaoTest {

  @Autowired
  private CandidateProfileDao profileDao;
  
  @Autowired
  private CandidateProfileService profileService;

  @Test
  @Transactional
  @Rollback(true)
  public void saveCandidateProfileSuccess() throws Exception {
    CandidateProfile profile = new CandidateProfile();
    profile.setFullName("Tran Tuan");
    profile.setGender("0");
    profile.setProfileId(50);
    assertTrue(profileDao.save(profile));
  }
  
  @Test
  @Transactional
  @Rollback(true)
  public void saveCandidateProfileFail() throws Exception {
    CandidateProfile profile = new CandidateProfile();
    profile.setFullName("Tran Tuan");
    profile.setProfileId(0);
    assertFalse(profileDao.save(profile));
  }
  
  @Test
  @Transactional
  @Rollback(true)
  public void findCurrentBiggestIdSuccess() throws Exception {
    int sizeTest = profileService.findCurrentBiggestId();
    assertEquals(profileDao.findCurrentBiggestId(),sizeTest);
  }
  
  @Test
  @Transactional
  @Rollback(true)
  public void findDuplicateAccountSuccess() throws Exception {
	  int sizeTest = profileService.findDuplicateAccount("Tran Tuan");
    assertEquals(profileDao.findDuplicateAccount("Tran Tuan"), sizeTest);
  }
}
