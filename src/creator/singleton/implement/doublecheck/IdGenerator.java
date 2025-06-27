package creator.singleton.implement.doublecheck;

import java.util.concurrent.atomic.AtomicLong;

/** 双重检查 */
public class IdGenerator {
  private static final AtomicLong id = new AtomicLong();
  private static volatile IdGenerator instance;

  private IdGenerator() {}

  public static IdGenerator getInstance() {
    if (instance == null) {
      synchronized (IdGenerator.class) { // 此处为类级别的锁
        if (instance == null) {
          instance = new IdGenerator();
        }
      }
    }
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
