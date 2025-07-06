package structor.decorator.decorator;

import java.util.Date;
import structor.decorator.common.TempDB;

/** 装饰对象，计算当月业务奖金 */
public class MonthPrize extends Decorator {

  /**
   * 通过构造函数传入被装饰的对象
   *
   * @param p
   */
  public MonthPrize(IPrize p) {
    super(p);
  }

  public double calcPrize(String user, Date begin, Date end) {
    // 1. 先获取前面运算出来的奖金
    double money = super.calcPrize(user, begin, end);
    // 2. 然后计算当月业务奖金，按人员和时间去获取当月业务额，然后在乘以 3%
    double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
    System.out.println(user + " 当月业务奖金 " + prize);
    return money + prize;
  }
}
