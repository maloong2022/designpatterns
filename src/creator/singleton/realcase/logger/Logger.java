package creator.singleton.realcase.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 实战案例一：处理资源访问冲突 */
public class Logger {
  private static final Logger instance = new Logger();
  private final FileWriter writer;

  private Logger() {
    File file = new File("log.txt");
    try {
      writer = new FileWriter(file, true); // true表示追加写入
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Logger getInstance() {
    return instance;
  }

  public void log(String message) throws IOException {
    writer.write(message + "\n");
  }
}
