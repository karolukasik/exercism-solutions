import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

class Flattener {
    private List<Object> flattenList;

    public Flattener() {
        this.flattenList = new ArrayList<>();
    }

    public Collection<Object> flatten(Collection<Object> list) {
        for (Object object : list) {
            if (object == null) {
                continue;
            } else if (object instanceof Collection) {
                flatten((Collection) object);
            } else {
                this.flattenList.add(object);
            }
        }
        return this.flattenList;
    }

    public static void main(String[] args) {
        List<Object> test = new ArrayList<>(asList("0", 2,
                asList(asList("two", '3'),
                        "8",
                        singletonList(singletonList("one hundred")),
                        null,
                        singletonList(singletonList(null))),
                "negative two"));
        Flattener flattener = new Flattener();
        System.out.println(flattener.flatten(test));
    }

}
