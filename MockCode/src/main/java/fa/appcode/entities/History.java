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

/**
 * The persistent class for the History database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class History implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "histoey_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int historyId;

  @Column(name = "history_log")
  private String historyLog;

  // bi-directional many-to-one association to Candidate
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "candidate_id")
  @JsonBackReference
  private Candidate candidate;

  private Date dates;
  private String remark;

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public History() {
  }

  public int getHistoryId() {
    return this.historyId;
  }

  public void setHistoryId(int hisId) {
    this.historyId = hisId;
  }

  public Date getDates() {
    return dates;
  }

  public void setDates(Date dates) {
    this.dates = dates;
  }

  public String getHistoryLog() {
    return this.historyLog;
  }

  public void setHistoryLog(String historyLog) {
    this.historyLog = historyLog;
  }

  public Candidate getCandidate() {
    return this.candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  @Override
  public String toString() {
    return "History [historyId=" + historyId + ", historyLog=" + historyLog
        + ", candidate=" + candidate + ", dates=" + dates + ", remark=" + remark
        + "]";
  }

}