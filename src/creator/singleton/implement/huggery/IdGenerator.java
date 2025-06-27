package creator.singleton.implement.huggery;

import java.util.concurrent.atomic.AtomicLong;

/** 饿汉式 */
public class IdGenerator {
  private static final AtomicLong id = new AtomicLong();
  private static final IdGenerator instance = new IdGenerator();

  private IdGenerator() {}

  public static IdGenerator getInstance() {
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
