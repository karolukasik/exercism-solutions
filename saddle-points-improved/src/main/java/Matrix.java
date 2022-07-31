import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class Matrix {

    private List<List<Integer>> elements;

    public Matrix(List<List<Integer>> elements) {
        this.elements = elements;
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<MatrixCoordinate>();
        for (int r = 0; r < getNumberOfRows(); r++) {
            for (int c = 0; c < getNumberOfColumns(); c++) {
                if (isSaddlePoint(r, c)) {
                    saddlePoints.add(new MatrixCoordinate(r + 1, c + 1));
                }
            }
        }
        return saddlePoints;
    }

    private int getNumberOfRows() {
        return elements.size();
    }

    private int getNumberOfColumns() {
        return elements.get(0).size();
    }

    private boolean isSaddlePoint(int r, int c) {
        return isMaximumInRow(r, c) && isMinimumInColumn(r, c);
    }

    private boolean isMaximumInRow(int r, int c) {
        return IntStream.range(0, getNumberOfColumns()).allMatch(y -> elements.get(r).get(y) <= elements.get(r).get(c));
    }

    private boolean isMinimumInColumn(int r, int c) {
        return IntStream.range(0, getNumberOfRows()).allMatch(x -> elements.get(x).get(c) >= elements.get(r).get(c));
    }

    public static void main(String[] args) {
        List<Integer> firstRow = Stream.of(9, 8, 7)
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> secondRow = Stream.of(5, 3, 2)
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> thirdRow = Stream.of(6, 6, 7)
                .collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> matrixValues = Stream.of(firstRow, secondRow, thirdRow)
                .collect(Collectors.toCollection(ArrayList::new));
        Matrix matrix = new Matrix(matrixValues);

        Set<MatrixCoordinate> saddlePoints = matrix.getSaddlePoints();

        for (MatrixCoordinate matrixCoordinate : saddlePoints) {
            System.out.println(matrixCoordinate.toString());
        }

    }
}
