package creator.factory.abstractfactory.impl;

import creator.factory.abstractfactory.IConfigParserFactory;
import creator.factory.abstractfactory.IRuleConfigParser;
import creator.factory.abstractfactory.ISystemConfigParser;
import creator.factory.abstractfactory.parserimpl.rule.PropertiesRuleConfigParser;
import creator.factory.abstractfactory.parserimpl.system.PropertiesSystemConfigParser;

public class PropertiesConfigParserFactory implements IConfigParserFactory {

  @Override
  public IRuleConfigParser createRuleParser() {
    return new PropertiesRuleConfigParser();
  }

  @Override
  public ISystemConfigParser createSYstemParser() {
    return new PropertiesSystemConfigParser();
  }
}
