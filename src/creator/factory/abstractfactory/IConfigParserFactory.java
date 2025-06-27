package creator.factory.abstractfactory;

public interface IConfigParserFactory {
  IRuleConfigParser createRuleParser();

  ISystemConfigParser createSYstemParser();
  // 此处可以扩展新的parser类型，比如IBizConfigParser
}
