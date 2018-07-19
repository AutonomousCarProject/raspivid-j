import java.io.IOException;

public class PullData {

  public static void main(String[] args) {
    try {
      new Streamer().start().frameStream();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
