package fa.appcode.service;

import fa.appcode.entities.CandidateProfile;

public interface CandidateProfileService {
  boolean save(CandidateProfile candidateProfile) throws Exception;

  int findCurrentBiggestId() throws Exception;

  int findDuplicateAccount(String account);

  /* CandidateProfile findByProfileId(int id); */
}
