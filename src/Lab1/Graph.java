package Lab1;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph extends Matrix {
    Graph(int n, int m) {
        super(n, m);
    }

    Graph(int[][] mat) {
        super(mat);
    }


    private int findMinLength(int start, int finish, LinkedList<Integer> list, int length) {
        int newLength = 0;
        list.add(start);
        for (int i = 0; i < row; i++) {
            if (matrix[start][i] != 0) {
                if (i == finish) {
                    list.add(i);
                    newLength = list.size() - 1;
                    if (newLength < length)
                        length = newLength;
                    list.removeLast();
                }
                else if (!list.contains(i)) {
                    length = findMinLength(i, finish, list, length);
                }
            }

            if (i == row - 1) {
                list.removeLast();
            }
        }
        return length;
    }

    private int findMaxLength(int start, int finish, LinkedList<Integer> list, int length) {
        int newLength = 0;
        list.add(start);
        for (int i = 0; i < row; i++) {
            if (matrix[start][i] != 0) {
                if (i == finish) {
                    list.add(i);
                    newLength = list.size() - 1;
                    if (newLength > length)
                        length = newLength;
                    list.removeLast();
                }
                else if (!list.contains(i)) {
                    length = findMaxLength(i, finish, list, length);
                }
            }

            if (i == row - 1) {
                list.removeLast();
            }
        }
        return length;
    }

    public int findMinLength(int start, int finish) {
        if (start == finish)
            return 0;
        LinkedList<Integer> list = new LinkedList();
        int length = matrix[0].length * matrix.length;

        return findMinLength(start, finish, list, length);
    }

    public int findMaxLength(int start, int finish) {
        if (start == finish)
            return 0;
        LinkedList<Integer> list = new LinkedList();
        int length = 0;
        return findMaxLength(start, finish, list, length);
    }

    public void print() { // for test
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
