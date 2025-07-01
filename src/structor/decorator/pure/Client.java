package structor.decorator.pure;

/** 测试客户端 */
public class Client {
  public static void main(String[] args) {
    Prize p = new Prize();

    double zs = p.calcPrize("张三", null, null);
    System.out.println("===============张三应得奖金：" + zs);
    double ls = p.calcPrize("李四", null, null);
    System.out.println("===============李四应得奖金：" + ls);
    double ww = p.calcPrize("王五", null, null);
    System.out.println("===============王五应得奖金：" + ww);
  }
}
