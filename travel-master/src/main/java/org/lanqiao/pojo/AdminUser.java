package org.lanqiao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_pz_admin_user")
public class AdminUser {
  @TableId
  private String id;
  private String addUserId;
  private java.sql.Timestamp addTime;
  private long deleteStatus;
  private String modifyUserId;
  private java.sql.Timestamp modifyTime;
  private String userName;
  private String password;
  private String linkTel;
  private String name;
  private long state;


}
