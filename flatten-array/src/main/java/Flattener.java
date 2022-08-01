import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Objects;


class Flattener {

    public Flattener() {
    }

    public static Collection<Object> flatten(Collection<Object> list) {
        return list.stream().flatMap(obj -> obj instanceof Collection ? Flattener.flatten((Collection<Object>)obj).stream() : Stream.of(obj)).filter(Objects::nonNull).collect(Collectors.toList());
    }



}
