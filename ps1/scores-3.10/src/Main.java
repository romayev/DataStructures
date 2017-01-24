import java.util.Arrays;

public class Main {

    private static final int R = 4;
    private static final int C = 3;

    public static void main(String[] args) {
        // Initialize the spreadsheet / table
        double[] row0 = {70.0, 80.0, 90.0};  // 240
        double[] row1 = {100.0, 70.0, 90.0}; // 260
        double[] row2 = {60.0, 70.0, 80.0};  // 210
        double[] row3 = {100.0, 90.0, 90.0}; // 280

        double[][] table = new double[][]{row0, row1, row2, row3};

        // Initialize output arrays
        double[] rowTotal = new double[R];
        double[] colTotal = new double[C];
        double[] colAverage = new double[C];

        // Loop through all rows (students)
        for (int row = 0; row < R; row++) {
            // Loop through all the columns (classes)
            for (int col = 0; col < C; col++) {
                double grade = table[row][col];
                System.out.format("Value[%d][%s]=%f\n", row, col, grade);
                // Add the grade (value in the current row /column) to the total for the current row
                rowTotal[row] += grade;
                // Add the grade (value in the current row / column) to the total for the current col
                colTotal[col] += grade;

                System.out.println("Row Totals: " + Arrays.toString(rowTotal));
                System.out.println("Col Totals: " + Arrays.toString(colTotal));

                // If this is the last row, then all the values for this column's total are filled in
                // (look at your sample spreadsheet to understand). You can calculate the average.
                if (row == R - 1) {
                    colAverage[col] = colTotal[col] / R;
                    System.out.println("Last row, calculated average for column: " + col + ": " + colAverage[col]);
                }

                System.out.println();
            }
        }
        System.out.println("*** Average ***");
        System.out.println(Arrays.toString(colAverage));
    }
}