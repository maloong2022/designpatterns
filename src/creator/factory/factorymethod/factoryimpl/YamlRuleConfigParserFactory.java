package creator.factory.factorymethod.factoryimpl;

import creator.factory.factorymethod.IRuleConfigParser;
import creator.factory.factorymethod.IRuleConfigParserFactory;
import creator.factory.factorymethod.parserimpl.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new YamlRuleConfigParser();
  }
}
