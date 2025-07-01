package structor.bridge.pure;

public class UrgencyMessageEmail implements UrgencyMessage {

  @Override
  public Object watch(String messageId) {
    // 获取相应的数据，组织成监控的数据对象，然后返回
    return null;
  }

  @Override
  public void send(String message, String toUser) {
    message = "加急" + message;
    System.out.println("使用 E-mail 的方式，发送消息'" + message + "'给" + toUser);
  }
}
