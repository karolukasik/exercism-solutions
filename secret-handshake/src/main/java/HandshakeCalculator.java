import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> secretHandshake = new ArrayList<>();

        String numberInBinaryString = Integer.toBinaryString(number);
        if (numberInBinaryString.length() > 5) {
            numberInBinaryString = numberInBinaryString.substring(numberInBinaryString.length() - 5,
                    numberInBinaryString.length());
        }
        int numberInBinaryInt = Integer.parseInt(numberInBinaryString);

        for (int i = 0; i < numberInBinaryString.length(); i++) {
            int digitInCheckingPosition = numberInBinaryInt % 10;
            if (digitInCheckingPosition == 1 && i != 4) {
                secretHandshake.add(digitToSignalTranslation(i));
            } else if (digitInCheckingPosition == 1 && i == 4) {
                secretHandshake = reverseList(secretHandshake);
            }
            numberInBinaryInt = numberInBinaryInt / 10;
        }
        return secretHandshake;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HandshakeCalculator calc = new HandshakeCalculator();
        System.out.print("Input: ");
        int number = Integer.parseInt(scan.nextLine());

        List<Signal> secretHandshake = calc.calculateHandshake(number);

        for (Signal signal : secretHandshake) {
            System.out.println(signal);
        }

        scan.close();

    }

    public static Signal digitToSignalTranslation(int digitPosition) {
        if (digitPosition == 0) {
            return Signal.WINK;
        } else if (digitPosition == 1) {
            return Signal.DOUBLE_BLINK;
        } else if (digitPosition == 2) {
            return Signal.CLOSE_YOUR_EYES;
        } else if (digitPosition == 3) {
            return Signal.JUMP;
        } else {
            return null;
        }

    }

    public static List<Signal> reverseList(List<Signal> listOfSignals) {
        List<Signal> reversedList = new ArrayList<>();
        for (int i = listOfSignals.size() - 1; i >= 0; i--) {
            reversedList.add(listOfSignals.get(i));
        }
        return reversedList;
    }

}
