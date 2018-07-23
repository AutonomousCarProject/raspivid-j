import java.io.IOException;
import java.util.Arrays;

public class PullData {

  public static void main(String[] args) {
    try {
      byte[] a = new byte[100];
      int retcode;
      Streamer s = new Streamer().start();
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
