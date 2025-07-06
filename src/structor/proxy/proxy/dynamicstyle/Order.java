package structor.proxy.proxy.dynamicstyle;

public class Order implements OrderApi {
  private String productName;
  private String orderUser;
  private int OrderNumber;

  public Order(String productName, String orderUser, int orderNumber) {
    this.productName = productName;
    this.orderUser = orderUser;
    OrderNumber = orderNumber;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName,String user) {
    this.productName = productName;
  }

  @Override
  public String getOrderUser() {
    return orderUser;
  }

  @Override
  public void setOrderUser(String orderUser, String user) {
    this.orderUser = orderUser;
  }

  @Override
  public int getOrderNumber() {
    return OrderNumber;
  }

  @Override
  public void setOrderNumber(int orderNumber, String user) {
    OrderNumber = orderNumber;
  }

  @Override
  public String toString() {
    return "Order{" +
            "productName='" + productName + '\'' +
            ", orderUser='" + orderUser + '\'' +
            ", OrderNumber=" + OrderNumber +
            '}';
  }
}
