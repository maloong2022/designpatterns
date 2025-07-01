package structor.decorator.decorator;

import java.util.Date;

/** 计算奖金的接口 */
public interface IPrize {
  double calcPrize(String user, Date begin, Date end);
}
