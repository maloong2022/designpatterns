package structor.bridge.bridge;


public class UrgencyMessage extends AbstractMessage {

  public UrgencyMessage(MessageImplementor impl) {
    super(impl);
  }

  @Override
  public void sendMessage(String message, String toUser) {
    message = "【加急】" + message;
    super.sendMessage(message, toUser);
  }

  /**
   * 扩展自己的新功能：监控某消息的处理过程
   *
   * @param messageId 被监控的消息的编号
   * @return 包含监控到的数据对象，这里示意一下，所以用了 Object
   */
  Object watch(String messageId) {
    // 获取相应的数据，组织成监控的数据对象，然后返回
    return null;
  }
}
