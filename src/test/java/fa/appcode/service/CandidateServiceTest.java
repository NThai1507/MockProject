package fa.appcode.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fa.appcode.dao.CandidateDaoImpll;
import fa.appcode.entities.Candidate;
import fa.appcode.entities.CandidateProfile;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceTest {

  @InjectMocks
  private PhuocCandidateServiceImpl candidateService;

  @Mock
  private CandidateDaoImpll candidateDao;
  
 

  @Test
  public void testSaveCandidateSuccess() throws Exception {
    Candidate candidate = new Candidate();
    CandidateProfile profile = new CandidateProfile();
    candidate.setCandidateProfile(profile);
    candidate.getCandidateProfile().setFullName("Tran Minh");
    when(candidateDao.save(candidate)).thenReturn(true);
    assertTrue(candidateService.save(candidate));
  }
  
  
 

}
