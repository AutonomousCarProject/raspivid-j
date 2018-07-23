package attributes.enums;

import attributes.Attribute;
import attributes.enums.InitialState.InitialStateMode;

public enum InitialState implements Attribute<InitialStateMode> {

  // TODO

  ;

  @Override
  public InitialStateMode[] get() {
    return new InitialStateMode[0];
  }

  @Override
  public Attribute<InitialStateMode> set(InitialStateMode[] v) {
    return this;
  }

  @Override
  public String getInvocationName() {
    return null;
  }

  public enum InitialStateMode {

  }

}
