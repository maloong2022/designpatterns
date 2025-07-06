package structor.decorator.decorator;

/** 测试客户端 */
public class Client {
  public static void main(String[] args) {
    // 先创建计算基本奖金的类，这也是被装饰的对象
    DefaultPrize defaultPrize = new DefaultPrize();

    // 然后对计算基本奖金进行装饰，这里要组合各个装饰
    // 说明：各个装饰者之间最好是不要有先后顺序的限制
    // 也就是先装饰谁和后装饰谁都一样

    // 先组合普通业务员的奖金计算
    Decorator monthPrize = new MonthPrize(defaultPrize);
    Decorator sumPrize = new SumPrize(monthPrize);

    // 注意：这里只需要使用最后组合好的对象调用业务方法即可，会依次调用回去
    // 日期对象都没有用上，所以传 null 即可
    double zs = sumPrize.calcPrize("张三", null, null);
    System.out.println("===============张三应得奖金：" + zs);
    double ls = sumPrize.calcPrize("李四", null, null);
    System.out.println("===============李四应得奖金：" + ls);

    // 如果是业务经理，还需要计算一个团队的奖金
    Decorator groupPrize = new GroupPrize(sumPrize);
    double ww = groupPrize.calcPrize("王五", null, null);
    System.out.println("===============王经理应得奖金：" + ww);
  }
}
