package Lab1;

public class Matrix {
    protected int[][] matrix;
    protected int row;
    protected int col;

    Matrix(int n, int m) {
        row = n;
        col = m;
        matrix = new int[row][col];
    }

    Matrix(int[][] mat) {
        matrix = mat;
        row = mat.length;
        col = mat[0].length;
    }

    protected int[][] getMatrix() {
        return matrix;
    }


}
