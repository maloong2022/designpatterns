package structor.proxy.proxy.dynamicstyle;

/** 订单对象的接口定义 */
public interface OrderApi {
  String getProductName();

  void setProductName(String productName, String user);

  int getOrderNumber();

  void setOrderNumber(int orderNumber, String user);

  String getOrderUser();

  void setOrderUser(String orderUser, String user);
}
