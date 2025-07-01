package structor.proxy.proxy.staticstyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import structor.proxy.common.MysqlUtil;

/** JDBC实现 PRD 需求 */
public class UserManager {
  public Collection<UserModelApi> getUserByDepId(String depId) throws Exception {
    Collection<UserModelApi> users = new ArrayList<>();
    Connection conn = null;
    try {
      conn = MysqlUtil.getConnection();
      // 只需要查出用户 ID 和 用户名字
      String sql =
          "select u.userid, u.name from tbl_user u, tbl_dep d  where u.depid = d.depid and d.depid like ? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, depId + "%");
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        // 这里是创建代理对象，而不是直接创建 UserModel对象
        Proxy proxy = new Proxy(new UserModel());
        // 只设置 userId和 Name 两个值就可以了
        proxy.setUserId(rs.getString("userid"));
        proxy.setName(rs.getString("name"));

        users.add(proxy);
      }
      rs.close();
      pstmt.close();
    } finally {
      conn.close();
    }
    return users;
  }
}
