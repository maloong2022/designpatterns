package creator.factory.abstractfactory.impl;

import creator.factory.abstractfactory.IConfigParserFactory;
import creator.factory.abstractfactory.IRuleConfigParser;
import creator.factory.abstractfactory.ISystemConfigParser;
import creator.factory.abstractfactory.parserimpl.rule.YamlRuleConfigParser;
import creator.factory.abstractfactory.parserimpl.system.YamlSystemConfigParser;

public class YamlConfigParserFactory implements IConfigParserFactory {

  @Override
  public IRuleConfigParser createRuleParser() {
    return new YamlRuleConfigParser();
  }

  @Override
  public ISystemConfigParser createSYstemParser() {
    return new YamlSystemConfigParser();
  }
}
