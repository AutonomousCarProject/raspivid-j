import attributes.Attribute;
import attributes.BoolAttribute;
import attributes.IntAttribute;
import attributes.StrAttribute;
import attributes.enums.Exposure;
import java.io.IOException;
import java.util.Arrays;

public class PullData {

  public static void main(String[] args) {
    try {
      byte[] a = new byte[100];
      int retcode;
      Streamer s = new Streamer(new Attribute[]{BoolAttribute.NOPREVIEW, IntAttribute.ISO.set(new
          Integer[]{1000}), StrAttribute.OUTPUT.set(new String[]{"-"}), Exposure.EXPOSURE})
          .start();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      switch (retcode = s.frameStream().read(a)) {
        case 0:
        case -1:
          System.out.println("Read failed with code " + retcode);
          break;
        default:
          System.out.println(Arrays.toString(a));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
