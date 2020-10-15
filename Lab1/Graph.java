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

    public static void main(String[] args) {

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
        for (int i = 0; i < row; i++) {
            countСycle(i, i, list, allCycle);
        }
        return allCycle.size();
    }

    private LinkedList<Integer> sort(LinkedList<Integer> list) {
        int min = list.getFirst();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        for (int i = 0; list.getFirst() != min; i++) {
            int k = list.getFirst();
            for (int j = 0; j < list.size() - 1; j++) {
                list.set(j, list.get(j + 1));
            }
            list.set(list.size() - 1, k);
        }

        return list;
    }

    private boolean listContains(LinkedList<LinkedList> all, LinkedList<Integer> list) {
        boolean isContains;
        boolean reverseContains;
        for (int i = 0; i < all.size(); i++) {
            isContains = true;
            reverseContains = true;
            LinkedList<Integer> v = all.get(i);
            if (list.size() == v.size()) {
                for (int j = 0; j < list.size(); j++) {
                    if (v.get(j) != list.get(j)) {
                        isContains = false;
                    }
                    if (j > 0 && v.getFirst() == list.getFirst()) {
                        if (v.get(j) != list.get(list.size() - j)) {
                            reverseContains = false;
                        }
                    }
                    else if (v.getFirst() != list.getFirst())
                        reverseContains = false;
                }
                if (isContains || reverseContains)
                    return true;
            }
        }

        return false;
    }

    private LinkedList<LinkedList> countСycle(int start, int finish, LinkedList<Integer> list, LinkedList<LinkedList> all) {
        list.add(start);
        for (int i = 0; i < row; i++) {
            if (matrix[start][i] != 0) {
                if (i == finish && list.size() - 1 > 1) {
                    LinkedList<Integer> slist = new LinkedList<>(list);
                    if (!listContains(all, sort(slist))) {
                        all.add(new LinkedList(slist));
                        if (!slist.contains(0) && slist.getFirst() == 1)
                            System.out.println(slist);
                    }
                }
                else if(!list.contains(i)) {
                    if (start == list.getLast())
                        all = countСycle(i, finish, list, all);
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
}
