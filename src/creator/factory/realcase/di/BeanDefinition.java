package creator.factory.realcase.di;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
  private final List constructorArgs = new ArrayList<>();
  private final Scope scope = Scope.SINGLETON;
  private final boolean lazyInit = false; // 省略必要的getter/setter/constructors
  private String id;
  private String className;

  public List getConstructorArgs() {
    return constructorArgs;
  }

  public Scope getScope() {
    return scope;
  }

  public boolean isLazyInit() {
    return lazyInit;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public boolean isSingleton() {
    return scope.equals(Scope.SINGLETON);
  }

  public enum Scope {
    SINGLETON,
    PROTOTYPE
  }

  public static class ConstructorArg {
    private boolean isRef;
    private Class type;

    private Object arg;

    public boolean isRef() {
      return isRef;
    }

    public void setRef(boolean ref) {
      isRef = ref;
    }

    public Class getType() {
      return type;
    }

    public void setType(Class type) {
      this.type = type;
    }

    public Object getArg() {
      return arg;
    }

    public void setArg(Object arg) {
      this.arg = arg;
    }
  }
}
