package fa.appcode.service;

import java.util.List;

import fa.appcode.entities.Candidate;

public interface CandidateService {
  List<Candidate> doList();

  boolean doSave(Candidate candidate);

  boolean doUpdate(Candidate candidate);

  Candidate doFindByIdCandidate(int id);
}
