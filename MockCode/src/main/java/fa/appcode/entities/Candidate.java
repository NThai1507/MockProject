package fa.appcode.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the Candidate database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class Candidate implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "candidate_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int candidateId;

  @Column(name = "application_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date applicationDate;

  @OneToOne(cascade = CascadeType.ALL)
  private Location location;

  @OneToOne(cascade = CascadeType.ALL)
  private CandidateProfile candidateProfile;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Channel channel;

  @OneToMany(mappedBy = "candidate",
      fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<EntryTest> entryTests;

  @OneToMany(mappedBy = "candidate", 
      fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Interview> interviews;

  private String status;
  private String remark;

  @OneToMany(mappedBy = "candidate",
      fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<History> histories;

  public Set<History> getHistories() {
    return histories;
  }

  public void setHistories(Set<History> histories) {
    this.histories = histories;
  }

  public Candidate() {
  }

  public int getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(int candidateId) {
    this.candidateId = candidateId;
  }

  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    this.applicationDate = applicationDate;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public CandidateProfile getCandidateProfile() {
    return candidateProfile;
  }

  public void setCandidateProfile(CandidateProfile candidateProfile) {
    this.candidateProfile = candidateProfile;
  }

  public Channel getChannel() {
    return channel;
  }

  public void setChannel(Channel channel) {
    this.channel = channel;
  }

  public Set<EntryTest> getEntryTests() {
    return entryTests;
  }

  public void setEntryTests(Set<EntryTest> entryTests) {
    this.entryTests = entryTests;
  }

  public Set<Interview> getInterviews() {
    return interviews;
  }

  public void setInterviews(Set<Interview> interviews) {
    this.interviews = interviews;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public String toString() {
    return "Candidate [candidateId=" + candidateId + ", applicationDate="
        + applicationDate + ", location=" + location + ", candidateProfile="
        + candidateProfile + ", channel=" + channel + ", entryTests="
        + entryTests + ", interviews=" + interviews + ", status=" + status
        + ", remark=" + remark + "]";
  }

}