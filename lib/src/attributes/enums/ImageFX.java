package attributes.enums;

import attributes.Attribute;
import attributes.enums.ImageFX.ImageFXMode;

public enum ImageFX implements Attribute<ImageFXMode> {
  IMAGE_FX(ImageFXMode.NONE, "ifx");

  public final String shortname;
  ImageFXMode v;

  ImageFX(ImageFXMode defaultV, String shortname) {
    this.v = defaultV;
    this.shortname = shortname;
  }

  @Override
  public ImageFXMode[] get() {
    return new ImageFXMode[]{v};
  }

  @Override
  public Attribute<ImageFXMode> set(ImageFXMode[] v) {
    this.v = v[0];
    return this;
  }

  @Override
  public String getInvocationName() {
    return shortname;
  }

  public enum ImageFXMode {
    NONE, NEGATIVE, SOLARISE, SKETCH, DENOISE, EMBOSS, OILPAINT, HATCH, GPEN, PASTEL, WATERCOLOUR,
    FILM, BLUR, SATURATION, COLOURSWAP, WASHEDOUT, POSTERISE, COLOURPOINT, COLOURBALANCE, CARTOON;

    @Override
    public String toString() {
      return this.name().toLowerCase();
    }
  }
}


