package fa.appcode.dao;

import fa.appcode.entities.CandidateProfile;

public interface CandidateProfileDao {

  boolean save(CandidateProfile candidateProfile) throws Exception;

  int findCurrentBiggestId() throws Exception;

  int findDuplicateAccount(String account);

  /* CandidateProfile findByProfileId(int id); */
}
