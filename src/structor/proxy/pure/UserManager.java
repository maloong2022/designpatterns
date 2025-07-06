package structor.proxy.pure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import structor.proxy.common.MysqlUtil;

/** JDBC实现 PRD 需求 */
public class UserManager {
  public Collection<UserModel> getUserByDepId(String depId) throws Exception {
    Collection<UserModel> users = new ArrayList<>();
    Connection conn = null;
    try {
      conn = MysqlUtil.getConnection();
      String sql =
          "select * from tbl_user u, tbl_dep d  where u.depid = d.depid and d.depid like ? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, depId + "%");
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        UserModel user = new UserModel();
        user.setUserId(rs.getString("userid"));
        user.setName(rs.getString("name"));
        user.setDepId(rs.getString("depid"));
        user.setSex(rs.getString("sex"));
        users.add(user);
      }
      rs.close();
      pstmt.close();
    } finally {
      conn.close();
    }
    return users;
  }
}
