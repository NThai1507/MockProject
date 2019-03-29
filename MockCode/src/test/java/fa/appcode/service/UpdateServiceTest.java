package fa.appcode.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fa.appcode.common.valueobjects.CandidateInformationVo;
import fa.appcode.common.valueobjects.Counter;
import fa.appcode.dao.CandidateDaoImpl;
import fa.appcode.entities.Candidate;
import fa.appcode.entities.CandidateProfile;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UpdateServiceTest {

  @InjectMocks
  private CandidateServiceImpl candidateService;

  @Mock
  private CandidateDaoImpl candidateDao;

  @Test
  public void testUpdateCandidateSuccess() throws Exception {
    Candidate candidate = new Candidate();
    candidate.setCandidateId(1);
    CandidateProfile profile = new CandidateProfile();
    candidate.setCandidateProfile(profile);
    candidate.getCandidateProfile().setFullName("Tran Minh");
    when(candidateDao.update(candidate)).thenReturn(true);
    assertTrue(candidateService.doUpdate(candidate));
  }

  @Test
  public void testFindByPageSuccess() throws Exception {
    CandidateInformationVo candidateInformationVo = new CandidateInformationVo();
    List<CandidateInformationVo> list = new ArrayList<>();
    list.add(candidateInformationVo);
    list.add(candidateInformationVo);
    list.add(candidateInformationVo);
    list.add(candidateInformationVo);
    list.add(candidateInformationVo);
    when(candidateDao.findByPage(new CandidateInformationVo(), 1, 5,
        new Counter())).thenReturn(list);
    assertEquals(5, list.size());

  }

}
