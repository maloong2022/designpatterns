package creator.singleton.implement.mutil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/** 多例模式：可以创建多个，但是总数有限制:一个类可以创建多个对象，但是个数是有限制的，比如只能创建 3 个对象 */
public class BackendServer {
  private static final int SERVER_COUNT = 3;
  private static final Map<Long, BackendServer> serverInstances =
      new HashMap<Long, BackendServer>();

  static {
    serverInstances.put(1L, new BackendServer(1L, "192.168.22.138:8080"));
    serverInstances.put(2L, new BackendServer(2L, "192.168.22.139:8080"));
    serverInstances.put(3L, new BackendServer(3L, "192.168.22.140:8080"));
  }

  private final long serverNo;
  private final String serverAddress;

  private BackendServer(long serverNo, String serverAddress) {
    this.serverNo = serverNo;
    this.serverAddress = serverAddress;
  }

  public static BackendServer getInstance(long serverNo) {
    return serverInstances.get(serverNo);
  }

  public static BackendServer getRandomInstance() {
    Random r = new Random();
    int no = r.nextInt(SERVER_COUNT) + 1;
    return serverInstances.get(no);
  }
}
