import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        String numberInBinary = Integer.toBinaryString(number);
        List<Signal> secretHandshake = new ArrayList<>();
        int[] parts = numberInBinary.chars().map(charValue -> charValue - 48).toArray();
        for (int i : parts) {
            System.out.println(i);
        }

        return secretHandshake;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HandshakeCalculator calc = new HandshakeCalculator();
        System.out.print("Input: ");
        int number = Integer.parseInt(scan.nextLine());
        calc.calculateHandshake(number);

    }

}
