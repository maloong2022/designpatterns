package creator.factory.realcase.di;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BeansFactory {
  private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();
  private ConcurrentHashMap<String, Object> singletons = new ConcurrentHashMap<>();

  public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList)
      throws BeanCreationFailureException {
    for (BeanDefinition beanDefinition : beanDefinitionList) {
      this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
    }

    for (BeanDefinition beanDefinition : beanDefinitionList) {
      if (beanDefinition.isLazyInit() == false && beanDefinition.isSingleton()) {
        createBean(beanDefinition);
      }
    }
  }

  public Object getBean(String beanId)
      throws NoSuchBeanDefinitionException, BeanCreationFailureException {
    BeanDefinition beanDefinition = beanDefinitions.get(beanId);
    if (beanDefinition == null) {
      throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
    }
    return createBean(beanDefinition);
  }

  private Object createBean(BeanDefinition beanDefinition) throws BeanCreationFailureException {
    if (beanDefinition.isSingleton() && singletons.contains(beanDefinition.getId())) {
      return singletons.get(beanDefinition.getId());
    }

    Object bean = null;
    try {
      Class beanClass = Class.forName(beanDefinition.getClassName());
      List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgs();
      if (args.isEmpty()) {
        bean = beanClass.newInstance();
      } else {
        Class[] argClasses = new Class[args.size()];
        Object[] argObjects = new Object[args.size()];
        for (int i = 0; i < args.size(); i++) {
          BeanDefinition.ConstructorArg arg = args.get(i);
          if (!arg.isRef()) {
            argClasses[i] = arg.getType();
            argObjects[i] = arg.getArg();
          } else {
            BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
            if (refBeanDefinition == null) {
              throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
            }
            argClasses[i] = Class.forName(refBeanDefinition.getClassName());
            argObjects[i] = createBean(refBeanDefinition);
          }
        }
        bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
      }
    } catch (ClassNotFoundException
        | IllegalAccessException
        | InstantiationException
        | NoSuchMethodException
        | InvocationTargetException
        | NoSuchBeanDefinitionException e) {
      throw new BeanCreationFailureException("", e);
    }
    if (bean != null && beanDefinition.isSingleton()) {
      singletons.putIfAbsent(beanDefinition.getId(), bean);
      return singletons.get(beanDefinition.getId());
    }
    return bean;
  }
}
