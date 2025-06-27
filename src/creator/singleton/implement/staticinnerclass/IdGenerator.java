package creator.singleton.implement.staticinnerclass;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类实现
 */
public class IdGenerator {
    private final AtomicLong id = new AtomicLong();
    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public long getId() {
        return id.get();
    }

    private static class SingletonHolder {
        private static final IdGenerator INSTANCE = new IdGenerator();
    }
}
