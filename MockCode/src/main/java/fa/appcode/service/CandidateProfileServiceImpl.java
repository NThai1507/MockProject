package fa.appcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.dao.CandidateProfileDao;
import fa.appcode.entities.CandidateProfile;

@Service
public class CandidateProfileServiceImpl implements CandidateProfileService {

  @Autowired
  private CandidateProfileDao candidateProfileDao;

  @Override
  public boolean save(CandidateProfile candidateProfile)
      throws Exception {
    return candidateProfileDao.save(candidateProfile);

  }

  @Override
  public int findCurrentBiggestId() throws Exception {
    return candidateProfileDao.findCurrentBiggestId();
  }

  @Override
  public int findDuplicateAccount(String account) {
    return candidateProfileDao.findDuplicateAccount(account);
  }

  /*
   * public CandidateProfile findByProfileId(int id) { return
   * candidateProfileDao.findByProfileId(id); }
   */
}
