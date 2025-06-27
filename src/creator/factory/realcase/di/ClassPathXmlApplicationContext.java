package creator.factory.realcase.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext {
  private final BeansFactory beansFactory;
  private final BeanConfigParser beanConfigParser;

  public ClassPathXmlApplicationContext(String configLocation) {
    this.beansFactory = new BeansFactory();
    this.beanConfigParser = new XmlBeanConfigParser();
    try {
      loadBeanDefinitions(configLocation);
    } catch (BeanCreationFailureException e) {
      throw new RuntimeException(e);
    }
  }

  private void loadBeanDefinitions(String configLocation) throws BeanCreationFailureException {
    InputStream in = null;
    try {
      in = this.getClass().getClassLoader().getResourceAsStream("/" + configLocation);
      if (in == null) {
        throw new RuntimeException("Can not find config file: " + configLocation);
      }
      List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
      beansFactory.addBeanDefinitions(beanDefinitions);

    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          // TODO: log error
        }
      }
    }
  }

  @Override
  public Object getBean(String beanId) {
    try {
      return beansFactory.getBean(beanId);
    } catch (NoSuchBeanDefinitionException e) {
      throw new RuntimeException(e);
    } catch (BeanCreationFailureException e) {
      throw new RuntimeException(e);
    }
  }
}
