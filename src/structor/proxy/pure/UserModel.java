package structor.proxy.pure;

/** 用户模型 */
public class UserModel {
  private String userId;
  private String name;
  private String depId;
  private String sex;

  @Override
  public String toString() {
    return "UserModel{" +
            "userId='" + userId + '\'' +
            ", name='" + name + '\'' +
            ", depId='" + depId + '\'' +
            ", sex='" + sex + '\'' +
            '}';
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepId() {
    return depId;
  }

  public void setDepId(String depId) {
    this.depId = depId;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}
