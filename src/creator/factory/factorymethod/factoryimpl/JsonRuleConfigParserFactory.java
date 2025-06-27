package creator.factory.factorymethod.factoryimpl;

import creator.factory.factorymethod.IRuleConfigParser;
import creator.factory.factorymethod.IRuleConfigParserFactory;
import creator.factory.factorymethod.parserimpl.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new JsonRuleConfigParser();
  }
}
