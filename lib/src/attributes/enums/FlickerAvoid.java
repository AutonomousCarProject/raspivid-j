package attributes.enums;

import attributes.Attribute;
import attributes.enums.FlickerAvoid.FlickerAvoidMode;

public enum FlickerAvoid implements Attribute<FlickerAvoidMode> {
  FLICKER_AVOID(FlickerAvoidMode.OFF, "fli");

  public final String shortname;
  FlickerAvoidMode v;

  FlickerAvoid(FlickerAvoidMode defaultV, String shortname) {
    this.v = defaultV;
    this.shortname = shortname;
  }

  @Override
  public FlickerAvoidMode[] get() {
    return new FlickerAvoidMode[]{v};
  }

  @Override
  public Attribute<FlickerAvoidMode> set(FlickerAvoidMode[] v) {
    this.v = v[0];
    return this;
  }

  @Override
  public String getInvocationName() {
    return shortname;
  }

  public enum FlickerAvoidMode {
    OFF, AUTO, _50HZ, _60HZ;

    @Override
    public String toString() {
      return this.name().toLowerCase().replaceAll("_", "");
    }
  }
}


