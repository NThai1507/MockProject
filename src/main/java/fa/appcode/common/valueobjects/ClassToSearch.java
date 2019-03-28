package fa.appcode.common.valueobjects;

public class ClassToSearch {
  private String subjectType;
  private String status;
  private int planOfEnrolment;

  public ClassToSearch() {
    super();
  }

  public ClassToSearch(String subjectType, String status, int planOfEnrolment) {
    super();
    this.subjectType = subjectType;
    this.status = status;
    this.planOfEnrolment = planOfEnrolment;
  }

  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getPlanOfEnrolment() {
    return planOfEnrolment;
  }

  public void setPlanOfEnrolment(int planOfEnrolment) {
    this.planOfEnrolment = planOfEnrolment;
  }

}
