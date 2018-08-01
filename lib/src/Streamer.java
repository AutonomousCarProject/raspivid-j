import attributes.Attribute;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Streamer {

  public static final String[] defaultArgs = {"-n", "-o", "-", "-t", "0"};
  private TYPE type = TYPE.YUV;
  private Process process = null;
  private ProcessBuilder processBuilder;

  public Streamer() throws IOException {
    buildProcess(defaultArgs);
  }

  public Streamer(String... args) throws IOException {
    buildProcess(args);
  }

  public Streamer(Attribute[] attributes) throws IOException {
    // Go through the array of attributes. If the attribute's command form exists, iterate
    // through its args and put them into a String array. Pass that String array into buildProcess()

    // This cast is not redundant, it will not compile without it.
    // See https://stackoverflow.com/questions/31227149
    //noinspection RedundantCast
    buildProcess(Arrays.stream(attributes).map(Attribute::getCommand).filter(Optional::isPresent)
        .map(Optional::get).flatMap((array) -> (Arrays.stream((String[]) array))).toArray
            (String[]::new));
  }

  private void buildProcess(String[] args) throws IOException {
    // Test to see if the command is installed
    if (new DataInputStream(new ProcessBuilder(type.invocationName).start().getInputStream())
        .readUTF().equals("")) {
      throw new IllegalStateException("Command " + type.invocationName + " not found.");
    }

    // Probably not the most efficient, but this is only being called during construction so it's
    // probably fine
    ArrayList<String> command = new ArrayList<>(args.length + 1);
    command.add(type.invocationName);
    command.addAll(Arrays.asList(args));
    processBuilder = new ProcessBuilder(command);
  }

  public Optional<Process> getProcess() {
    return Optional.of(process);
  }

  public Streamer start() throws IOException {
    process = processBuilder.start();
    return this;
  }

  public void stop() {
    process.destroy();
  }

  public void restart() throws IOException {
    stop();
    start();
  }

  public InputStream frameStream() {
    return process.getInputStream();
  }

  public TYPE getType() {
    return type;
  }

  public void setType(TYPE type) {
    this.type = type;
  }

  public enum TYPE {
    YUV("raspividyuv"), H264("raspivid");

    private final String invocationName;

    TYPE(String invocationName) {
      this.invocationName = invocationName;
    }
  }

}
