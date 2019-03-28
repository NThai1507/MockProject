package fa.appcode.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the EntryTest database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class EntryTest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "test_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int testId;

  @Column(name = "test_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date testDate;
  @Column(name = "times")
  private int time;
  @Column(name = "language_result")
  private String languageResult;

  @Column(name = "language_valuator")
  private String languageValuator;

  private String remark;

  private String result;

  @Column(name = "technical_result")
  private String technicalResult;

  @Column(name = "technical_valuator")
  private String technicalValuator;

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "candidate_id")
  //  @JsonBackReference
  private Candidate candidate;

  public EntryTest() {
  }

  public int getTestId() {
    return testId;
  }

  public void setTestId(int testId) {
    this.testId = testId;
  }

  public Date getTestDate() {
    return testDate;
  }

  public void setTestDate(Date testDate) {
    this.testDate = testDate;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public String getLanguageResult() {
    return languageResult;
  }

  public void setLanguageResult(String languageResult) {
    this.languageResult = languageResult;
  }

  public String getLanguageValuator() {
    return languageValuator;
  }

  public void setLanguageValuator(String languageValuator) {
    this.languageValuator = languageValuator;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getTechnicalResult() {
    return technicalResult;
  }

  public void setTechnicalResult(String technicalResult) {
    this.technicalResult = technicalResult;
  }

  public String getTechnicalValuator() {
    return technicalValuator;
  }

  public void setTechnicalValuator(String technicalValuator) {
    this.technicalValuator = technicalValuator;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}