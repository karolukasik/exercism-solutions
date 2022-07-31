import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Flattener {
    public static Collection<Object> flatten(Collection<Object> input) {
        return input
                .stream()
                .flatMap(e -> e instanceof Collection ? Flattener.flatten((Collection<Object>) e).stream()
                        : Stream.of(e))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}