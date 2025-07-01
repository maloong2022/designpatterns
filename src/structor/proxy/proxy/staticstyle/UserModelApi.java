package structor.proxy.proxy.staticstyle;

/** 抽象的目标接口，定义具体的目标对象和代理公用接口 */
public interface UserModelApi {
  String getUserId();

  void setUserId(String userId);

  String getName();

  void setName(String userName);

  String getDepId();

  void setDepId(String depId);

  String getSex();

  void setSex(String sex);
}
