package fa.appcode.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.appcode.common.valueobjects.CandidateInformationVo;
import fa.appcode.common.valueobjects.Counter;
import fa.appcode.entities.Candidate;
import fa.appcode.entities.Channel;
import fa.appcode.entities.Faculty;
import fa.appcode.entities.Location;
import fa.appcode.entities.University;
import fa.appcode.service.CandidateServiceImpl;

@RestController
@RequestMapping("/")
public class ApiController {

  @Autowired
  private CandidateServiceImpl candidateServiceImpl;
  private static int countTotal;

  /**
   * this is method is controller.
   * 
   * @return
   */
  @PostMapping("findCandidateById")
  public Candidate findCandidateById(@RequestBody int id) {

    return candidateServiceImpl.doFindByIdCandidate(id);

  }

  @PostMapping("saveCandidate")
  public boolean saveCandidate(@RequestBody Candidate candidate) {
    return candidateServiceImpl.doSave(candidate);
  }

  @PostMapping("updateCandidate")
  public boolean updateCandidate(@RequestBody Candidate candidate) {
    return candidateServiceImpl.doUpdate(candidate);
  }

  @PostMapping("listAllLocation")
  public List<Location> listAllLocation() {
    return candidateServiceImpl.doListLocation();
  }

  @PostMapping("listAllUniversity")
  public List<University> listAllUniversity() {
    return candidateServiceImpl.doListUniversity();
  }

  @PostMapping("listAllChannel")
  public List<Channel> listAllChannel() {
    return candidateServiceImpl.doListChannel();
  }

  @PostMapping("listAllFaculty")
  public List<Faculty> listAllFaculty() {
    return candidateServiceImpl.doListFaculty();
  }

  /**
   * this is method is controller.
   * 
   * @return
   */
  @PostMapping("findByPage")
  public List<CandidateInformationVo> findByPage(
      @RequestBody CandidateInformationVo candidateInformationVo) {
    Counter counter = new Counter();
    counter.setCountTotal(0L);
    System.out.println(candidateInformationVo.toString());
    List<CandidateInformationVo> listCandidateInformationVo = 
        candidateServiceImpl
        .doFindByPage(candidateInformationVo, candidateInformationVo.getPage(),
            candidateInformationVo.getPageSizeResult(), counter);
    countTotal = counter.getCountTotal().intValue();
    return listCandidateInformationVo;
  }

  @PostMapping("countTotal")
  public int countTotal() {
    return countTotal;
  }

  @PostMapping("deleteInterview")
  public boolean deleteInterview(@RequestBody int id) {
    return candidateServiceImpl.doDeleteInterview(id);
  }

  @PostMapping("deleteEntryTest")
  public boolean deleteEntryTest(@RequestBody int id) {
    return candidateServiceImpl.doDeleteEntryTest(id);
  }

  @PostMapping("saveUniversity")
  public University saveLocation(@RequestBody University university) {
    return candidateServiceImpl.doSaveUniversity(university);
  }

  @PostMapping("saveFaculty")
  public Faculty saveFaculty(@RequestBody Faculty faculty) {
    return candidateServiceImpl.doSaveFaculty(faculty);

  }
}
