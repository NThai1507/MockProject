package fa.appcode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The persistent class for the Channel database table.
 * 
 */
@Entity
@Table(schema = "candidate")
public class Channel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "channel_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int channelId;

  @Column(name = "channel_name")
  private String channelName;

  private String remark;

  public Channel() {
  }

  public int getChannelId() {
    return channelId;
  }

  public void setChannelId(int channelId) {
    this.channelId = channelId;
  }

  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
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