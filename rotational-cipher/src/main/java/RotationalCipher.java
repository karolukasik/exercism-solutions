import java.util.function.Function;
import java.util.stream.Collectors;

class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars()
                .boxed()
                .map(createHandleStringLetter(shiftKey))
                .map(c -> Character.toString(c))
                .collect(Collectors.joining());

    }

    private static Function<Integer, Integer> createHandleStringLetter(int shiftKey) {
        return (charInASCII) -> {
            if (charInASCII >= 97 && charInASCII <= 122) {
                return (charInASCII + shiftKey <= 122) ? charInASCII + shiftKey
                        : 96 + (charInASCII - 122) + shiftKey;
            } else if (charInASCII >= 65 && charInASCII <= 90) {
                return (charInASCII + shiftKey <= 90) ? charInASCII + shiftKey
                        : 64 + (charInASCII - 90) + shiftKey;
            } else {
                return (charInASCII);
            }
        };

    }

    public static void main(String[] args) {
        RotationalCipher cipher = new RotationalCipher(13);
        System.out.println(cipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));
    }
}
