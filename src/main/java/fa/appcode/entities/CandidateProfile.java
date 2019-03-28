package fa.appcode.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the CandiadteProfile database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class CandidateProfile implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "profile_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int profileId;
  @Column(name = "full_name")
  private String fullName;
  private String account;

  @Column(name = "date_of_birth")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date dateOfBirth;
  private String gender;

  @OneToOne(cascade = CascadeType.ALL)
  private University university;
  @OneToOne(cascade = CascadeType.ALL)
  private Faculty faculty;
  @Column(name = "graduation_year")
  private String graduationYear;
  private String phone;
  private String email;
  private String cv;
  private String type;
  private String skill;
  @Column(name = "foreign_language")
  private String foreignLanguage;
  private String levels;
  private String note;
  private String remark;

  public CandidateProfile() {
  }

  public int getProfileId() {
    return profileId;
  }

  public void setProfileId(int profileId) {
    this.profileId = profileId;
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

  public String getGraduationYear() {
    return graduationYear;
  }

  public void setGraduationYear(String graduationYear) {
    this.graduationYear = graduationYear;
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

  public String getCv() {
    return cv;
  }

  public void setCv(String cv) {
    this.cv = cv;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  public String getForeignLanguage() {
    return foreignLanguage;
  }

  public void setForeignLanguage(String foreignLanguage) {
    this.foreignLanguage = foreignLanguage;
  }

  public String getLevels() {
    return levels;
  }

  public void setLevels(String levels) {
    this.levels = levels;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "CandidateProfile [profileId=" + profileId + ", fullName=" + fullName
        + ", account=" + account + ", dateOfBirth=" + dateOfBirth + ", gender="
        + gender + ", university=" + university + ", faculty=" + faculty
        + ", graduationYear=" + graduationYear + ", phone=" + phone + ", email="
        + email + ", cv=" + cv + ", type=" + type + ", skill=" + skill
        + ", foreignLanguage=" + foreignLanguage + ", levels=" + levels
        + ", note=" + note + ", remark=" + remark + "]";
  }

}