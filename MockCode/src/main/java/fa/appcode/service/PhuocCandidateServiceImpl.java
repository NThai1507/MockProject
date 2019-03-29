package fa.appcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.dao.CandidateDaoo;
import fa.appcode.entities.Candidate;

@Service
public class PhuocCandidateServiceImpl implements PhuocCandidateService {

  @Autowired
  private CandidateDaoo candidateDao;

  @Override
  public boolean save(Candidate candidate) throws Exception {
    return candidateDao.save(candidate);

  }

}
