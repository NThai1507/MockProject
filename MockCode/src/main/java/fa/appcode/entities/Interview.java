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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the interview database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class Interview implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "interview_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int interviewId;

  private String comments;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date date;

  private String interviewer;

  private String remark;

  private String result;

  private int time;

  // bi-directional many-to-one association to Candidate
  // @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "candidate_id")
  @JsonBackReference
  private Candidate candidate;

  public Interview() {
  }

  public int getInterviewId() {
    return interviewId;
  }

  public void setInterviewId(int interviewId) {
    this.interviewId = interviewId;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getInterviewer() {
    return interviewer;
  }

  public void setInterviewer(String interviewer) {
    this.interviewer = interviewer;
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

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
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