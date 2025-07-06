package structor.decorator.decorator;

import java.util.Date;
import structor.decorator.common.TempDB;

/** 装饰对象，计算当月团队奖金 */
public class GroupPrize extends Decorator {

  /**
   * 通过构造函数传入被装饰的对象
   *
   * @param p
   */
  public GroupPrize(IPrize p) {
    super(p);
  }

  public double calcPrize(String user, Date begin, Date end) {
    // 1. 先获取前面运算出来的奖金
    double money = super.calcPrize(user, begin, end);
    // 2. 然后计算当月团队业务奖金，先计算出团队的总业务额，然后乘以 1%;
    double group = 0.0;
    for (double b : TempDB.mapMonthSaleMoney.values()) {
      group += b;
    }
    double prize = group * 0.01;
    System.out.println(user + " 当月团队业务奖金 " + prize);
    return money + prize;
  }
}
