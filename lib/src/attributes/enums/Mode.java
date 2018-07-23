package attributes.enums;

import attributes.Attribute;
import attributes.enums.Mode.ModeMode;

public enum Mode implements Attribute<ModeMode> {

  // TODO

  ;

  @Override
  public ModeMode[] get() {
    return new ModeMode[0];
  }

  @Override
  public Attribute<ModeMode> set(ModeMode[] v) {
    return this;
  }

  @Override
  public String getInvocationName() {
    return null;
  }

  public enum ModeMode {

  }

}
