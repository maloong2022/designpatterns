package creator.builder;


import cn.hutool.core.util.StrUtil;

public class ResourcePoolConfig {
  private String name;
  private int maxTotal;
  private int maxIdle;
  private int minIdle;

  private ResourcePoolConfig(Builder builder) {
    this.name = builder.name;
    this.maxIdle = builder.maxIdle;
    this.maxTotal = builder.maxTotal;
    this.minIdle = builder.minIdle;
  }

  public String getName() {
    return name;
  }

  public int getMaxTotal() {
    return maxTotal;
  }

  public int getMaxIdle() {
    return maxIdle;
  }

  public int getMinIdle() {
    return minIdle;
  }

  // 我们将 Builder 类设计成了 ResourcePoolConfig 的内部类
  // 我们也可以将 Builder 类设计成独立的非内部类 ResourcePoolConfigBuilder
  public static class Builder {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;
    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig build() {
        // 校验逻辑放在这里来做，包括必填项校验，依赖关系校验，约束条件校验等
        if( StrUtil.isBlank(name)){
          throw new IllegalArgumentException("....");
        }
        if(maxIdle > maxTotal){
          throw new IllegalArgumentException("....");
        }
        if(minIdle > maxTotal || minIdle > maxIdle){
          throw new IllegalArgumentException("....");
        }

        return new ResourcePoolConfig(this);

    }
    public Builder setName(String name) {
      if(StrUtil.isBlank(name)){
        throw new IllegalArgumentException("....");
      }
      this.name = name;
      return this;
    }
    public Builder setMaxTotal(int maxTotal) {
      if( maxTotal < 0){
        throw new IllegalArgumentException("....");
      }
      this.maxTotal = maxTotal;
      return this;
    }
    public Builder setMaxIdle(int maxIdle) {
      if( maxIdle < 0){
        throw new IllegalArgumentException("....");
      }
      this.maxIdle = maxIdle;
      return this;
    }
    public Builder setMinIdle(int minIdle) {
      if( minIdle < 0){
        throw new IllegalArgumentException("....");
      }
      this.minIdle = minIdle;
      return this;
    }
  }
}
