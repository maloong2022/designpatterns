package creator.factory.abstractfactory.impl;

import creator.factory.abstractfactory.IConfigParserFactory;
import creator.factory.abstractfactory.IRuleConfigParser;
import creator.factory.abstractfactory.ISystemConfigParser;
import creator.factory.abstractfactory.parserimpl.rule.JsonRuleConfigParser;
import creator.factory.abstractfactory.parserimpl.system.JsonSystemConfigParser;

public class JsonConfigParserFactory implements IConfigParserFactory {

  @Override
  public IRuleConfigParser createRuleParser() {
    return new JsonRuleConfigParser();
  }

  @Override
  public ISystemConfigParser createSYstemParser() {
    return new JsonSystemConfigParser();
  }
}
