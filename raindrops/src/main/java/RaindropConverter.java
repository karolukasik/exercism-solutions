import java.util.HashMap;

class RaindropConverter {

    private static final HashMap<Integer, String> convertMap = new HashMap<>();

    static {
        convertMap.put(3, "Pling");
        convertMap.put(5, "Plang");
        convertMap.put(7, "Plong");
    }

    String convert(int number) {

        return convertMap.keySet().stream().filter(key -> number % key == 0).map(key -> convertMap.get(key))
                .reduce((s1, s2) -> s1 + s2).orElse(Integer.toString(number));

    }

}
