package a_手写稀疏矩阵;

/**
 * @author zijian Wang
 */
public class SparseMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[10][10];

        matrix[1][2] = 1;
        matrix[2][3] = 2;
        System.out.println("original Matrix:");
        printMatrix(matrix);

        System.out.println("To Sparse Matrix:");
        //To Sparse Matrix
        int[][] sparseMatrix = toSparseMatrix(matrix);

        System.out.println("To Matrix:");
        //To array
        toMatrix(sparseMatrix);
    }

    public static int[][] toSparseMatrix(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
//        count of matrix where value is not zero
        int countNotZero = getCountNotZero(matrix);
        // init sparse matrix
        int[][] spareMatrix = new int[countNotZero + 1][3];
        //header : row 、col、sum
        spareMatrix[0][0] = rowLength;
        spareMatrix[0][1] = colLength;
        spareMatrix[0][2] = countNotZero;

        //set value for sparse matrix
        int rowBegin = 1;//row count index
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    spareMatrix[rowBegin][0] = i;
                    spareMatrix[rowBegin][1] = j;
                    spareMatrix[rowBegin][2] = matrix[i][j];
                    rowBegin++;
                }
            }
        }
        printMatrix(spareMatrix);
        return spareMatrix;
    }

    public static int[][] toMatrix(int[][] spareMatrix) {
        //read header
        int rowLength = spareMatrix[0][0];
        int colLength = spareMatrix[0][1];
//        count of matrix where value is not zero
        int countNotZero = spareMatrix[0][2];

        int[][] matrix = new int[rowLength][colLength];
        for (int i = 1; i < spareMatrix.length; i++) {
            for (int j = 0; j < spareMatrix[i].length; j++) {
                matrix[spareMatrix[i][0]][spareMatrix[i][1]] = spareMatrix[i][2];
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    private static int getCountNotZero(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                if (col != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
