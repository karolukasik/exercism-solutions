import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Matrix {

    private int numberOfColumns;
    private int numberOfRows;
    private List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.numberOfRows = values.size();
        if (!values.isEmpty()) {
            this.numberOfColumns = values.get(0).size();
        } else {
            this.numberOfColumns = 0;
        }
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        boolean checkedValueGreatestOrEqualInTheRow;
        boolean checkedValueSmallestOrEqualInTheColumn;

        for (int i = 0; i < this.numberOfRows; i++) {
            for (int j = 0; j < this.numberOfColumns; j++) {
                checkedValueGreatestOrEqualInTheRow = true;
                checkedValueSmallestOrEqualInTheColumn = true;
                int checkedValue = values.get(i).get(j);
                // check row
                for (int k = 0; k < this.numberOfColumns; k++) {
                    if (k == j) {
                        continue;
                    }
                    int comparedValue = values.get(i).get(k);
                    if (checkedValue >= comparedValue) {
                        continue;
                    } else {
                        checkedValueGreatestOrEqualInTheRow = false;
                        break;
                    }
                }
                // check column
                for (int l = 0; l < this.numberOfRows; l++) {
                    if (l == i) {
                        continue;
                    }
                    int comparedValue = values.get(l).get(j);
                    if (checkedValue <= comparedValue) {
                        continue;
                    } else {
                        checkedValueSmallestOrEqualInTheColumn = false;
                        break;
                    }
                }
                // add to set if saddle
                if (checkedValueGreatestOrEqualInTheRow && checkedValueSmallestOrEqualInTheColumn) {
                    saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }
        return saddlePoints;
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

        Matrix matrixEmpty = new Matrix(new ArrayList<>());

        Set<MatrixCoordinate> saddlePoints = matrixEmpty.getSaddlePoints();

        for (MatrixCoordinate matrixCoordinate : saddlePoints) {
            System.out.println(matrixCoordinate.toString());
        }

    }
}
