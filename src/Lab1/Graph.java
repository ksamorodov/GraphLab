package Lab1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Graph extends Matrix {
    Graph(int n, int m) {
        super(n, m);
    }

    Graph(int[][] mat) {
        super(mat);
    }

    public static void main(String[] args) {

    }

//    public int countConnectivityComponent() {
//        LinkedList<LinkedList> all = new LinkedList<>();
//        LinkedList<Integer> done = new LinkedList<>();
//        LinkedList<Integer> temp = new LinkedList<>();
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (matrix[i][j] == 1 || matrix[j][i] == 1) {
//                    matrix[i][j] = matrix[j][i] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < row - 1; i++) {
//            temp.add(i);
//            done.add(i);
//            for (int j = i + 1; j < col; j++) {
//                if (findMinLength(i, j) > 0) {
//                    temp.add(j);
//                    done.add(j);
//                    if (!done.contains(j)) {
//
//                    }
//                }
//                else {
//                    if (!done.contains(j)) {
//                        all.add(temp);
//                        temp = new LinkedList<>();
//                        temp.add(j);
//                    }
//                }
//            }
//
//        }
//    }

    private void deepFirstSearch (int num, boolean[] usedVertex, Vector<Integer> comps, LinkedList<LinkedList> path, int count) {
        usedVertex[num] = true;
        comps.add(num);

        for (int i = 0; i < path.get(num).size(); i++) {
            int to = (int) path.get(num).get(i);
            if (!usedVertex[to])
                deepFirstSearch(to, usedVertex, comps, path, count);
        }
    }

    public int countComps() {
        LinkedList<LinkedList> path = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < row; i++) {
            path.add(new LinkedList());
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 0) {
                    path.get(i).add(j);
                }
            }
        }

        boolean[] usedVertex = new boolean[row];
        Vector<Integer> comps = new Vector<>();

        for (int i = 0; i < row; i++) {
            usedVertex[i] = false;
        }

        for (int i = 0; i < row; i++) {
            if (!usedVertex[i]) {
                comps.clear();
                deepFirstSearch(i, usedVertex, comps, path, count);
                count++;
                System.out.print("Component: ");
                for (int j = 0; j < comps.size(); j++) {
                    System.out.print(" " + comps.get(j));
                }
                System.out.println();
            }
        }
        return count;
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
                        //if (!slist.contains(0) && slist.getFirst() == 1)
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
