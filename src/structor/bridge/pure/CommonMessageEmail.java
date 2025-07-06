package structor.bridge.pure;

/** 以 E-mail 的方式发送普通消息 */
public class CommonMessageEmail implements Message {
  @Override
  public void send(String message, String toUser) {
    System.out.println("使用 E-mail 的方式，发送消息'" + message + "'给" + toUser);
  }
}
