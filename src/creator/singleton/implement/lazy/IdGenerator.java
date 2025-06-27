package creator.singleton.implement.lazy;

import java.util.concurrent.atomic.AtomicLong;

/** 懒汉式 */
public class IdGenerator {
  private static final AtomicLong id = new AtomicLong();
  private static IdGenerator instance;

  private IdGenerator() {}

  public static synchronized IdGenerator getInstance() {
    if (instance == null) {
      instance = new IdGenerator();
    }
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
