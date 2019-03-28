package fa.appcode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name = "Users", schema = "candidate")
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
public class Users implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "users_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int usersId;

  private String passwords;

  @Column(name = "users_name")
  private String usersName;

  // bi-directional many-to-one association to Role
  @OneToOne
  private Role role;

  public Users() {
  }

  public int getUsersId() {
    return this.usersId;
  }

  public void setUsersId(int usersId) {
    this.usersId = usersId;
  }

  public String getPasswords() {
    return this.passwords;
  }

  public void setPasswords(String passwords) {
    this.passwords = passwords;
  }

  public String getUsersName() {
    return this.usersName;
  }

  public void setUsersName(String usersName) {
    this.usersName = usersName;
  }

  public Role getRole() {
    return this.role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Users [usersId=" + usersId + ", passwords=" + passwords
        + ", usersName=" + usersName + ", role=" + role + "]";
  }

}