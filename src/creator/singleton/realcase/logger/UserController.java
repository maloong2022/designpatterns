package creator.singleton.realcase.logger;

import java.io.IOException;

/** Logger类的应用示例 */
public class UserController {

  public void login(String username, String password) throws IOException {
    // ...
    Logger.getInstance().log(username + " logined!");
  }
}
