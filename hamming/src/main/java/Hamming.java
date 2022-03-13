public class Hamming {
    String leftStrand;
    String rightStrand;
    int hammingDistance;

    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {

        if (validateStrands(leftStrand, rightStrand)) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
            this.hammingDistance = 0;
            for (int i = 0; i < this.leftStrand.length(); i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                    hammingDistance++;
                }
            }
        }
    }

    public int getHammingDistance() {
        return this.hammingDistance;
    }

    public boolean validateStrands(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (!leftStrand.isEmpty() && rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        return true;
    }


}
