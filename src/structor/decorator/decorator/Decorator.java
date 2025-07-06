package structor.decorator.decorator;

import java.util.Date;

/** 装饰器基类 */
public abstract class Decorator implements IPrize {
  /** 持有被装饰的组件对象 */
  protected IPrize p;

  /** 通过构造函数传入被装饰的对象 */
  public Decorator(IPrize p) {
    this.p = p;
  }

  @Override
  public double calcPrize(String user, Date begin, Date end) {
    return p.calcPrize(user, begin, end);
  }
}
