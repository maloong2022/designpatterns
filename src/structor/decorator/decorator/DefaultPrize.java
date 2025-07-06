package structor.decorator.decorator;

import java.util.Date;

/**
 * 默认计算奖金实现类，也就是被装饰的对象
 */
public class DefaultPrize implements IPrize {
  public double calcPrize(String user, Date begin, Date end) {
    return 0;
  }
}
