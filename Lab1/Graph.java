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
        if (list.size() - 1 >= length) {
            list.removeLast();
            return length;
        }

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

    public int findMinLength(int start, int finish) {
        if (start == finish)
            return 0;
        LinkedList<Integer> list = new LinkedList();
        int length = matrix[0].length * matrix.length;
        int result = findMinLength(start, finish, list, length);
        if (result == matrix[0].length * matrix.length) {
            System.out.println("Не существует");
            result = 0;
        }
        return result;
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

    public int countСycle() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<LinkedList> allCycle = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < row; i++) {
            countСycle(i, i, list, count, allCycle);
        }
        return allCycle.size();
    }

    private LinkedList<Integer> sort(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    var k = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, k);
                }
            }
        }
        return list;
    }

    private boolean listContains(LinkedList<LinkedList> all, LinkedList<Integer> list) {
        for (int i = 0; i < all.size(); i++) {
            LinkedList<Integer> v = all.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.size() == v.size()) {
                        if (v.get(j) != list.get(j)) {
                            break;
                        }
                        return true;
                    }
                }
            }

        return false;
    }

    private LinkedList<LinkedList> countСycle(int start, int finish, LinkedList<Integer> list, int count, LinkedList<LinkedList> all) {
        list.add(start);
        for (int i = 0; i < row; i++) {
            if (matrix[start][i] != 0) {
                if (i == finish && list.size() - 1 > 1) {
                    System.out.print(' ');
                    if (!listContains(all, sort(list))) {
                        all.add(new LinkedList(list));
                    }
                }
                else if(!list.contains(i)) {
                    all = countСycle(i, finish, list, count, all);
                }
            }
            if (i == row - 1) {
                list.removeLast();
            }
        }
        return all;
    }

    public int findMaxLength(int start, int finish) {
        if (start == finish)
            return 0;

        LinkedList<Integer> list = new LinkedList();
        int length = 0;
        int result = findMaxLength(start, finish, list, length);
        if (result == 0) {
            System.out.println("Не существует");
        }
        return result;
    }

    public void print() { // for test
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    // при нахождении цикла отсортировать вершины и сравнить, есть ли такой цикл
}
