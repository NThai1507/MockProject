package fa.appcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.common.valueobjects.CandidateInformationVo;
import fa.appcode.common.valueobjects.Counter;
import fa.appcode.dao.CandidateDaoImpl;
import fa.appcode.entities.Candidate;
import fa.appcode.entities.Channel;
import fa.appcode.entities.EntryTest;
import fa.appcode.entities.Faculty;
import fa.appcode.entities.Interview;
import fa.appcode.entities.Location;
import fa.appcode.entities.University;

@Service
public class CandidateServiceImpl implements CandidateService {

  @Autowired
  private CandidateDaoImpl candidateDaoImpl;

  @Override
  public List<Candidate> doList() {

    return candidateDaoImpl.lists();
  }

  @Override
  public boolean doSave(Candidate candidate) {

    return candidateDaoImpl.save(candidate);
  }

  @Override
  public boolean doUpdate(Candidate candidate) {
    // TODO Auto-generated method stub
    return candidateDaoImpl.update(candidate);
  }

  /**
   * this method to delete Interview.
   * 
   * @param id int.
   * @return
   */
  public boolean doDeleteInterview(int id) {
    Interview interview = new Interview();
    interview.setInterviewId(id);
    return candidateDaoImpl.deleteInterview(interview);
  }

  /**
   * this method to delete Entrytest.
   * 
   * @param id int.
   * @return
   */
  public boolean doDeleteEntryTest(int id) {
    // TODO Auto-generated method stub

    EntryTest entryTest = new EntryTest();
    entryTest.setTestId(id);
    return candidateDaoImpl.deleteEntryTest(entryTest);
  }

  @Override
  public Candidate doFindByIdCandidate(int id) {
    // TODO Auto-generated method stub
    return candidateDaoImpl.findByIdCandidate(id);
  }

  public List<Location> doListLocation() {

    return candidateDaoImpl.listAllLocation();
  }

  public List<University> doListUniversity() {

    return candidateDaoImpl.listAllUniversity();
  }

  public List<Faculty> doListFaculty() {

    return candidateDaoImpl.listAllFaculty();
  }

  public List<Channel> doListChannel() {

    return candidateDaoImpl.listAllChannel();
  }

  /**
   * this method to padding.
   * 
   * @return
   */
  public List<CandidateInformationVo> doFindByPage(
      CandidateInformationVo candidateInformationVo, int page,
      int pageSizeResult, Counter counter) {
    List<CandidateInformationVo> listCandidateInformationVo = null;
    try {
      listCandidateInformationVo = candidateDaoImpl
          .findByPage(candidateInformationVo, page, pageSizeResult, counter);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listCandidateInformationVo;
  }

  public University doSaveUniversity(University university) {

    return candidateDaoImpl.saveUniversity(university);
  }

  public Faculty doSaveFaculty(Faculty faculty) {

    return candidateDaoImpl.saveFaculty(faculty);
  }

}
