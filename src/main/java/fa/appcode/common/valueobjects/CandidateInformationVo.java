package fa.appcode.common.valueobjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import fa.appcode.entities.Faculty;
import fa.appcode.entities.University;

public class CandidateInformationVo {
  private int candidateId;
  private String fullName;
  private String account;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date dateOfBirth;
  private String gender;
  private University university;
  private Faculty faculty;
  private String phone;
  private String email;
  private String status;
  private int page;
  private int pageSizeResult;
  private Long counterAll;

  public CandidateInformationVo() {
    super();
    // TODO Auto-generated constructor stub
  }

  public CandidateInformationVo(int candidateId, String fullName,
      String account, Date dateOfBirth, String gender, University university,
      Faculty faculty, String phone, String email, String status) {
    super();
    this.candidateId = candidateId;
    this.fullName = fullName;
    this.account = account;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.university = university;
    this.faculty = faculty;
    this.phone = phone;
    this.email = email;
    this.status = status;
  }

  public int getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(int candidateId) {
    this.candidateId = candidateId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public University getUniversity() {
    return university;
  }

  public void setUniversity(University university) {
    this.university = university;
  }

  public Faculty getFaculty() {
    return faculty;
  }

  public void setFaculty(Faculty faculty) {
    this.faculty = faculty;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPageSizeResult() {
    return pageSizeResult;
  }

  public void setPageSizeResult(int pageSizeResult) {
    this.pageSizeResult = pageSizeResult;
  }

  public Long getCounterAll() {
    return counterAll;
  }

  public void setCounterAll(Long counterAll) {
    this.counterAll = counterAll;
  }

  
  
}
