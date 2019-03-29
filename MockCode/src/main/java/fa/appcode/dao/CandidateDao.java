package fa.appcode.dao;

import java.util.List;

import fa.appcode.common.valueobjects.CandidateInformationVo;
import fa.appcode.common.valueobjects.Counter;
import fa.appcode.entities.Candidate;

public interface CandidateDao {
  List<Candidate> lists();

  boolean save(Candidate candidate);

  boolean update(Candidate candidate);

  Candidate findByIdCandidate(int id);

  List<CandidateInformationVo> findByPage(
      CandidateInformationVo candidateInformationVo, int page,
      int pageSizeResult, Counter counter) throws Exception;

}
