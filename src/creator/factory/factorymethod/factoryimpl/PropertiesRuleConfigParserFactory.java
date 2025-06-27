package creator.factory.factorymethod.factoryimpl;

import creator.factory.factorymethod.IRuleConfigParser;
import creator.factory.factorymethod.IRuleConfigParserFactory;
import creator.factory.factorymethod.parserimpl.PropertiesRuleConfigParser;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new PropertiesRuleConfigParser();
  }
}
