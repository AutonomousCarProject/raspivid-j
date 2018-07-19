package attributes;

import org.jetbrains.annotations.NotNull;

public enum BoolAttribute implements Attribute<Boolean> {
  HELP(false, "?"),
  VERBOSE(false, "v"),
  DEMO(false, "d"),
  TIMED(false, "td"),
  SIGNAL(false, "s"),
  KEYPRESS(false, "k"),
  SETTINGS(false, "set"),
  FULLSCREEN(false, "f"),
  NOPREVIEW(true, "n"),
  VSTAB(false, "vs");

  @NotNull
  public final String shortname;
  @NotNull
  private Boolean v;

  BoolAttribute(Boolean defaultV, String shortname) {
    v = defaultV;
    this.shortname = shortname;
  }

  @Override
  public Boolean[] get() {
    return new Boolean[]{v};
  }

  @Override
  public void set(Boolean[] v) {
    this.v = v[0];
  }

  @Override
  public String getInvocationName() {
    return shortname;
  }

  @Override
  public String getCommand() {
    if (v) {
      return shortname;
    } else {
      return "";
    }
  }
}