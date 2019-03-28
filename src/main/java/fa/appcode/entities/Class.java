package fa.appcode.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the Class database table.
 * 
 */
@Entity
@NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c")
@Table(schema = "candidate")
public class Class implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "class_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int classId;

  @Column(name = "class_admin_id")
  private int classAdminId;

  @Column(name = "class_code")
  private String classCode;

  @Column(name = "class_name")
  private String className;

  @Column(name = "expected_end_date")
  private Date expectedEndDate;

  @Column(name = "expected_start_date")
  private Date expectedStartDate;

  @Column(name = "learning_path")
  private Date learningPath;

  @OneToOne
  private Location location;

  @Column(name = "planned_trainee_number")
  private BigDecimal plannedTraineeNumber;

  @Column(name = "statuz")
  private String status;

  @Column(name = "subject_type")
  private String subjectType;

  @Column(name = "trainer_id")
  private int trainerId;

  public Class() {
  }

  public int getClassId() {
    return classId;
  }

  public void setClassId(int classId) {
    this.classId = classId;
  }

  public int getClassAdminId() {
    return classAdminId;
  }

  public void setClassAdminId(int classAdminId) {
    this.classAdminId = classAdminId;
  }

  public String getClassCode() {
    return classCode;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Date getExpectedEndDate() {
    return expectedEndDate;
  }

  public void setExpectedEndDate(Date expectedEndDate) {
    this.expectedEndDate = expectedEndDate;
  }

  public Date getExpectedStartDate() {
    return expectedStartDate;
  }

  public void setExpectedStartDate(Date expectedStartDate) {
    this.expectedStartDate = expectedStartDate;
  }

  public Date getLearningPath() {
    return learningPath;
  }

  public void setLearningPath(Date learningPath) {
    this.learningPath = learningPath;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public BigDecimal getPlannedTraineeNumber() {
    return plannedTraineeNumber;
  }

  public void setPlannedTraineeNumber(BigDecimal plannedTraineeNumber) {
    this.plannedTraineeNumber = plannedTraineeNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  public int getTrainerId() {
    return trainerId;
  }

  public void setTrainerId(int trainerId) {
    this.trainerId = trainerId;
  }

  public Class(int classId, int classAdminId, String classCode,
      String className, Date expectedEndDate, Date expectedStartDate,
      Date learningPath, Location location, BigDecimal plannedTraineeNumber,
      String status, String subjectType, int trainerId) {
    super();
    this.classId = classId;
    this.classAdminId = classAdminId;
    this.classCode = classCode;
    this.className = className;
    this.expectedEndDate = expectedEndDate;
    this.expectedStartDate = expectedStartDate;
    this.learningPath = learningPath;
    this.location = location;
    this.plannedTraineeNumber = plannedTraineeNumber;
    this.status = status;
    this.subjectType = subjectType;
    this.trainerId = trainerId;
  }

}