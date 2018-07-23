package attributes.enums;

import attributes.Attribute;
import attributes.enums.InitialState.InitialStateMode;

public enum InitialState implements Attribute<InitialStateMode> {
  INITIAL_STATE(InitialStateMode.RECORD, "i");

  public final String shortname;
  InitialStateMode v;

  InitialState(InitialStateMode defaultV, String shortname) {
    this.v = defaultV;
    this.shortname = shortname;
  }

  @Override
  public InitialStateMode[] get() {
    return new InitialStateMode[]{v};
  }

  @Override
  public Attribute<InitialStateMode> set(InitialStateMode[] v) {
    this.v = v[0];
    return this;
  }

  @Override
  public String getInvocationName() {
    return shortname;
  }

  public enum InitialStateMode {
    RECORD, PAUSE;

    @Override
    public String toString() {
      return this.name().toLowerCase();
    }
  }
}


