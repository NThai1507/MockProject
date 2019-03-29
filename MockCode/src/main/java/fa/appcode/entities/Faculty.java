package fa.appcode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the Faculty database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class Faculty implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "faculty_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int facultyId;

  @Column(name = "faculty_name")
  private String facultyName;

  private String remark;

  public Faculty() {
  }

  public int getFacultyId() {
    return facultyId;
  }

  public void setFacultyId(int facultyId) {
    this.facultyId = facultyId;
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
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

}