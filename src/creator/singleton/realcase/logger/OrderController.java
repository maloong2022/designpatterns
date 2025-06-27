package creator.singleton.realcase.logger;

import java.io.IOException;

public class OrderController {

  public void create(OrderVo order) throws IOException {
    // ...省略业务逻辑代码...
    Logger.getInstance().log("Created an order: " + order.toString());
  }

  static class OrderVo {}
}
