package structor.decorator.decorator;

import java.util.Date;

/** 装饰对象，计算累计奖金 */
public class SumPrize extends Decorator {

  /**
   * 通过构造函数传入被装饰的对象
   *
   * @param p
   */
  public SumPrize(IPrize p) {
    super(p);
  }

  public double calcPrize(String user, Date begin, Date end) {
    // 1. 先获取前面运算出来的奖金
    double money = super.calcPrize(user, begin, end);
    // 2. 然后计算累计奖金，其实是按照人员去获取累计的业务额，然后乘以 0.1%
    double prize = 1000000 * 0.001;
    System.out.println(user + " 累计奖金 " + prize);
    return money + prize;
  }
}
