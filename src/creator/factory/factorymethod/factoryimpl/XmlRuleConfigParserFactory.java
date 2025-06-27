package creator.factory.factorymethod.factoryimpl;

import creator.factory.factorymethod.IRuleConfigParser;
import creator.factory.factorymethod.IRuleConfigParserFactory;
import creator.factory.factorymethod.parserimpl.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new XmlRuleConfigParser();
  }
}
