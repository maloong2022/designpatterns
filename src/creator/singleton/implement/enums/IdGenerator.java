package creator.singleton.implement.enums;

import java.util.concurrent.atomic.AtomicLong;

/** 枚举实现 */
public enum IdGenerator {
  INSTANCE;
  private final AtomicLong id = new AtomicLong(0);

  public long getId() {
    return id.incrementAndGet();
  }
}
