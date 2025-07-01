package structor.proxy.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlUtil {
  /**
   * 获取与数据库的链接
   *
   * @return
   */
  public static Connection getConnection() throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/tb", "root", "");
  }
}
