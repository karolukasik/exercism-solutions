import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) throws IllegalArgumentException {
        if (square <= 0 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return (new BigInteger("2").pow(square - 1));
    }

    BigInteger grainsOnBoard() {
        BigInteger grainsOnBoard = new BigInteger("0");
        for (int i = 1; i <= 64; i++) {
            grainsOnBoard = grainsOnBoard.add(grainsOnSquare(i));
        }
        return grainsOnBoard;
    }


}
