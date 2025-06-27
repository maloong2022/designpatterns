package creator.factory.abstractfactory.impl;

import creator.factory.abstractfactory.IConfigParserFactory;
import creator.factory.abstractfactory.IRuleConfigParser;
import creator.factory.abstractfactory.ISystemConfigParser;
import creator.factory.abstractfactory.parserimpl.rule.XmlRuleConfigParser;
import creator.factory.abstractfactory.parserimpl.system.XmlSystemConfigParser;

public class XmlConfigParserFactory implements IConfigParserFactory {

  @Override
  public IRuleConfigParser createRuleParser() {
    return new XmlRuleConfigParser();
  }

  @Override
  public ISystemConfigParser createSYstemParser() {
    return new XmlSystemConfigParser();
  }
}
