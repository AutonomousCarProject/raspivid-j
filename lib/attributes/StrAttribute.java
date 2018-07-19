package attributes;

import org.jetbrains.annotations.NotNull;

public enum StrAttribute implements Attribute<String> {

  OUTPUT(new String[]{"-"}, "o");

  @NotNull
  public final String shortname;
  private String[] vals;

  StrAttribute(String[] defaultV, String shortname) {
    vals = defaultV;
    this.shortname = shortname;
  }

  @Override
  public String[] get() {
    return vals;
  }

  @Override
  public void set(String[] v) {
    vals = v;
  }

  @Override
  public String getInvocationName() {
    return shortname;
  }
}
