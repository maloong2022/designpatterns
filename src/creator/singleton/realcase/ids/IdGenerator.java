package creator.singleton.realcase.ids;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

  private static final IdGenerator INSTANCE = new IdGenerator();
  private final AtomicLong id = new AtomicLong();

  private IdGenerator() {}

  public static IdGenerator getInstance() {
    return INSTANCE;
  }

  public long getId() {
    return id.incrementAndGet();
  }
  // 使用举例
  // long id = IdGenerator.getInstance().getId();
}
