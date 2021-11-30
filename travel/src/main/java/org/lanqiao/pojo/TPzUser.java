package org.lanqiao.pojo;


public class TPzUser {


  private String id;
  private String addUserId;
  private String addTime;
  private String deleteStatus;
  private String modifyUserId;
  private String modifyTime;
  private String userName;
  private String password;
  private String linkTel;
  private String name;
  private String icCode;
  private long state;
  private long province;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getAddUserId() {
    return addUserId;
  }

  public void setAddUserId(String addUserId) {
    this.addUserId = addUserId;
  }


  public java.sql.Timestamp getAddTime() {
    return addTime;
  }

  public void setAddTime(java.sql.Timestamp addTime) {
    this.addTime = addTime;
  }


  public long getDeleteStatus() {
    return deleteStatus;
  }

  public void setDeleteStatus(long deleteStatus) {
    this.deleteStatus = deleteStatus;
  }


  public String getModifyUserId() {
    return modifyUserId;
  }

  public void setModifyUserId(String modifyUserId) {
    this.modifyUserId = modifyUserId;
  }


  public java.sql.Timestamp getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(java.sql.Timestamp modifyTime) {
    this.modifyTime = modifyTime;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getLinkTel() {
    return linkTel;
  }

  public void setLinkTel(String linkTel) {
    this.linkTel = linkTel;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getIcCode() {
    return icCode;
  }

  public void setIcCode(String icCode) {
    this.icCode = icCode;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public long getProvince() {
    return province;
  }

  public void setProvince(long province) {
    this.province = province;
  }

}
