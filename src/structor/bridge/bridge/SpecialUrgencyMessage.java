package structor.bridge.bridge;

public class SpecialUrgencyMessage extends AbstractMessage {
    public SpecialUrgencyMessage(MessageImplementor impl) {
        super(impl);
    }


    public void sendMessage(String message, String toUser) {
        message = "🔥【特急】" + message;
        super.sendMessage(message, toUser);
        // 还需要增加一条催促的消息
    }

    public void hurry(String messageId) {
        // 执行催促业务，发出催促的信息
    }
}
