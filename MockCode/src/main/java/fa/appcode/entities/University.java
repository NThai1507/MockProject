package fa.appcode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the University database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class University implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "university_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int universityId;

  private String remark;

  @Column(name = "university_name")
  private String universityName;

  public University() {
  }

  public int getUniversityId() {
    return universityId;
  }

  public void setUniversityId(int universityId) {
    this.universityId = universityId;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}