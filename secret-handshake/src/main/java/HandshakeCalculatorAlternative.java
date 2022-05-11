import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculatorAlternative {
    // Collections.reverse
    // binary operators wygooglac

    List<Signal> calculateHandshake(int number) {
        List<Signal> handshakes = new ArrayList<>();
        if ((number & 1) << 0 != 0)
            handshakes.add(Signal.WINK);
        if ((number & 1 << 1) != 0)
            handshakes.add(Signal.DOUBLE_BLINK);
        if ((number & 1 << 2) != 0)
            handshakes.add(Signal.CLOSE_YOUR_EYES);
        if ((number & 1 << 3) != 0)
            handshakes.add(Signal.JUMP);
        if ((number & 1 << 4) != 0)
            Collections.reverse(handshakes);

        return handshakes;

    }

    public static void main(String[] args) {
        HandshakeCalculatorAlternative calc = new HandshakeCalculatorAlternative();
        int number = 19;
        List<Signal> secretHandshake = calc.calculateHandshake(number);

        for (Signal signal : secretHandshake) {
            System.out.println(signal);
        }
    }

}
