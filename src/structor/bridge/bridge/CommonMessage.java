package structor.bridge.bridge;

public class CommonMessage extends AbstractMessage {
  public CommonMessage(MessageImplementor impl) {
    super(impl);
  }

  @Override
  public void sendMessage(String message, String toUser) {
    // 对于普通消息，什么都都不干，直接调用父类的方法，把消息发送出去
    super.sendMessage(message, toUser);
  }
}
