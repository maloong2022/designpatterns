package structor.proxy.proxy.dynamicstyle;

/** 测试客户端 */
public class Client {
  public static void main(String[] args) {
    // 张三登录系统创建了一个订单
    Order order = new Order("设计模式", "张三", 100);

    // 创建一个动态代理
    DynamicProxy dynamicProxy = new DynamicProxy();
    // 然后把订单和动态代理关联起来
    OrderApi orderApi = dynamicProxy.getProxyInterface(order);
    System.out.println("修改前订单记录: " + orderApi);

    // 以下就需要使用被代理的接口来操作了
    // 李四想来修改，那就会报错
    orderApi.setOrderNumber(123, "李四");
    // 张三修改就不会有问题
    orderApi.setOrderNumber(123, "张三");
    // 再次输出 order
    System.out.println("张三修改后，订单记录：" + orderApi);
  }
}
