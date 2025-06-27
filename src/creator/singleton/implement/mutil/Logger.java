package creator.singleton.implement.mutil;

import java.util.concurrent.ConcurrentHashMap;

/** 多例模式，还有一种理解方式：同一类型的只能创建一个对象，不同类型的可以创建多个对象。 */
public class Logger {
  private static final ConcurrentHashMap<String, Logger> instances = new ConcurrentHashMap<>();

  private Logger() {}

  public static Logger getInstance(String loggerName) {
    instances.put(loggerName, new Logger());
    return instances.get(loggerName);
  }

  public void log(String message) {}

  // l1 == l2,l1!=l3 使用举例
  // Logger l1 = Logger.getInstance("User.class");
  // Logger l2 = Logger.getInstance("User.class");
  // Logger l3 = Logger.getInstance("Order.class");
}
