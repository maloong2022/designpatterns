package creator.factory.realcase.di;

public class BeanCreationFailureException extends Throwable {
  public BeanCreationFailureException(String s, Throwable e) {
    super(s, e);
  }
}
