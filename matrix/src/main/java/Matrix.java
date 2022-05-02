
class Matrix {

    static int numberOfRows;
    static int numberOfColumns;
    int matrix[][];

    Matrix(String matrixAsString) {
        // getting dimensions of matrix
        String[] rows = matrixAsString.split("\n");
        numberOfRows = rows.length;
        String[] rowValuesAsString = rows[0].split(" ");
        numberOfColumns = rowValuesAsString.length;

        // filling matrix with ints
        matrix = new int[numberOfRows][numberOfColumns];
        for (int r = 0; r < numberOfRows; r++) {
            String[] valuesInRowAsString = rows[r].split(" ");
            for (int c = 0; c < numberOfColumns; c++) {
                matrix[r][c] = Integer.parseInt(valuesInRowAsString[c]);
            }
        }

    }

    int[] getRow(int rowNumber) {
        int[] row = new int[numberOfColumns];
        if (rowNumber <= numberOfRows) {
            for (int i = 0; i < numberOfColumns; i++) {
                row[i] = matrix[rowNumber - 1][i];
            }
        }
        return row;
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[numberOfRows];
        if (columnNumber <= numberOfColumns) {
            for (int i = 0; i < numberOfRows; i++) {
                column[i] = matrix[i][columnNumber - 1];
            }
        }
        return column;
    }
}
