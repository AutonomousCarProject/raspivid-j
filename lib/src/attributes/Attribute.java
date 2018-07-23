package attributes;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Attribute<T> {

  T[] get();

  Attribute<T> set(T[] v);

  String getInvocationName();

  default String getCommand() {
    // Add the shortname together with the data
    return "-" + getInvocationName() + " " + Arrays.stream(get()).map(Object::toString).collect
        (Collectors.joining(" "));
  }

}
