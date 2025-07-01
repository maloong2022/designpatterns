package structor.proxy.proxy.staticstyle;

import java.util.Collection;

/** 测试用户端 */
public class Client {
  public static void main(String[] args) throws Exception {
    UserManager manager = new UserManager();
    Collection<UserModelApi> collection = manager.getUserByDepId("0101");
    // 如果只是显示用户名称，则不需要重新查询数据库
    for (UserModelApi user : collection) {
      System.out.println("用户编号:" + user.getUserId() + ",用户姓名：" + user.getName());
    }
    System.out.println("====================================================");
    // 如果访问非用户编码和用户姓名外的属性，那就会要重新查询数据库
    for (UserModelApi user : collection) {
      System.out.println(
          "用户编号:" + user.getUserId() + ",用户姓名：" + user.getName() + ",所属部门：" + user.getDepId());
    }
  }
}
