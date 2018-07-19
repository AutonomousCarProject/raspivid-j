package attributes.enums;

import attributes.Attribute;
import attributes.enums.Exposure.ExposureMode;

public enum Exposure implements Attribute<ExposureMode> {
  EXPOSURE(ExposureMode.AUTO, "ex");

  public final String shortname;
  ExposureMode v;

  Exposure(ExposureMode defaultV, String shortname) {
    this.v = defaultV;
    this.shortname = shortname;
  }

  @Override
  public ExposureMode[] get() {
    return new ExposureMode[]{v};
  }

  @Override
  public void set(ExposureMode[] v) {
    this.v = v[0];
  }

  @Override
  public String getInvocationName() {
    return shortname;
  }

  enum ExposureMode {
    AUTO, NIGHT, NIGHTPREVIEW, BACKLIGHT, SPOTLIGHT, SPORTS, SNOW, BEACH, VERYLONG, FIXEDFPS,
    ANTISHAKE, FIREWORKS;

    @Override
    public String toString() {
      return this.name().toLowerCase();
    }
  }
}


