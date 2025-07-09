import java.util.Arrays;

class Matrix {
    private final int[][] matrix;
    private final int rowCount;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        rowCount = rows.length;
        matrix = new int[rowCount][];
        int numberCount = rows[0].length() / 2 + 1;

        for (int i = 0; i < rows.length; i++) {
            int[] row = new int[numberCount];

            int j = 0;
            for (String num : rows[i].split(" ")) {
                row[j++] = Integer.parseInt(num);
            }

            matrix[i] = row;
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] col = new int[rowCount];
        for (int i = 0; i < rowCount; i++)
            col[i] = matrix[i][columnNumber - 1];
        return col;
    }
}

