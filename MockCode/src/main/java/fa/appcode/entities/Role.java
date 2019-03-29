package fa.appcode.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * The persistent class for the Roles database table.
 * 
 */
@Entity
@Table(name = "Roles", schema = "candidate")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")

public class Role implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int roleId;

  @Column(name = "role_name")
  private String roleName;

  public Role() {
  }

  public int getRoleId() {
    return this.roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  /** get role.
   * @return
   */
  @Transient
  public List<GrantedAuthority> getRoleName() {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    authorities.add(new SimpleGrantedAuthority(roleName));

    return authorities;
  }

  public void setRole(String roleName) {
    this.roleName = roleName;
  }

}