package fa.appcode.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fa.appcode.dao.CandidateProfileDaoImpl;
import fa.appcode.entities.CandidateProfile;

@RunWith(MockitoJUnitRunner.class)
public class CandidateProfileServiceTest {
  
  @InjectMocks
  private CandidateProfileServiceImpl profileSerivce;
  
  @Mock
  private CandidateProfileDaoImpl profileDao;
  
  @Test
  public void testFindCurrentBiggestIdSuccess() throws Exception {
   when(profileDao.findCurrentBiggestId()).thenReturn(5);
   assertEquals(profileSerivce.findCurrentBiggestId(), 5);
  }

  @Test
  public void testFindDuplicateAccountSucccess() {
    when(profileDao.findDuplicateAccount("Tran Tuan")).thenReturn(1);
    assertEquals(profileSerivce.findDuplicateAccount("Tran Tuan"),1);
  }
  
  @Test
  public void testSaveCandidateProfileSuccess() throws Exception {
    CandidateProfile profile = new CandidateProfile();
    when(profileDao.save(profile)).thenReturn(true);
    assertTrue(profileSerivce.save(profile));
  }
}
