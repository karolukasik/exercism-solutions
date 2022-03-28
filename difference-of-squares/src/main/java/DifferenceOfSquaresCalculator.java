class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sumOfFirstNNumbers = (input * (input + 1)) / 2;
        return sumOfFirstNNumbers * sumOfFirstNNumbers;
    }

    int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * (2 * input + 1)) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
