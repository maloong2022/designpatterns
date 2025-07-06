package structor.proxy.proxy.staticstyle;

import java.sql.*;
import structor.proxy.common.MysqlUtil;

/** 代理对象，代理用户数据 */
public class Proxy implements UserModelApi {
  /** 持有被代理的具体的目标对象 */
  private final UserModel userModel;

  /** 标记是否已经重新装载过数据了 */
  private boolean loaded = false;

  public Proxy(UserModel userModel) {
    this.userModel = userModel;
  }

  @Override
  public String getUserId() {
    return userModel.getUserId();
  }

  @Override
  public void setUserId(String userId) {
    userModel.setUserId(userId);
  }

  @Override
  public String getName() {
    return userModel.getName();
  }

  @Override
  public void setName(String userName) {
    userModel.setName(userName);
  }

  @Override
  public String getDepId() {
    // 需要判断是否已经装载过了
    if (!this.loaded) {
      // 从数据库重新装载
      reload();
      this.loaded = true;
    }

    return userModel.getDepId();
  }

  @Override
  public void setDepId(String depId) {
    userModel.setDepId(depId);
  }

  @Override
  public String getSex() {
    // 需要判断是否已经装载过了
    if (!this.loaded) {
      // 从数据库重新装载
      reload();
      this.loaded = true;
    }
    return userModel.getSex();
  }

  @Override
  public void setSex(String sex) {
    userModel.setSex(sex);
  }

  /** 重新查询数据库以获取完整的用户数据 */
  private void reload() {
    System.out.println("重新查询数据库获取完整的用户数据, userId：" + userModel.getUserId());
    Connection conn = null;
    try {
      conn = MysqlUtil.getConnection();
      String sql = "select * from tbl_user where userid = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userModel.getUserId());
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        // 只需要重新获取 userId 和 Name 外的数据
        userModel.setDepId(rs.getString("depid"));
        userModel.setSex(rs.getString("sex"));
      }
      rs.close();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
