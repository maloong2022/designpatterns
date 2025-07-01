package structor.decorator.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 在内存中模拟数据库，准备点测试数据，好计算奖金
 */
public class TempDB {
    public static Map<String,Double> mapMonthSaleMoney = new HashMap<>();

    static {
        mapMonthSaleMoney.put("张三", 10000.0);
        mapMonthSaleMoney.put("李四",20000.0);
        mapMonthSaleMoney.put("王五",30000.0);
    }

    private TempDB(){}
}
