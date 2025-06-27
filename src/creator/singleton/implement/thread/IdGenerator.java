package creator.singleton.implement.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/** 实现线程间的单例 */
public class IdGenerator {
  private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();
  private final AtomicLong id = new AtomicLong();

  private IdGenerator() {}

  public static IdGenerator getInstance() {
    Long currentThreadId = Thread.currentThread().getId();
    instances.putIfAbsent(currentThreadId, new IdGenerator());
    return instances.get(currentThreadId);
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
