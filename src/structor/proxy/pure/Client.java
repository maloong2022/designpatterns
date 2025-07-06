package structor.proxy.pure;

import java.util.Collection;

/** 测试客户端 */
public class Client {
  public static void main(String[] args) throws Exception {
    UserManager userManager = new UserManager();
    Collection<UserModel> col = userManager.getUserByDepId("0101");
    System.out.println(col);
  }
}
