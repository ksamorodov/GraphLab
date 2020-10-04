package Lab1;

import java.util.Scanner;

class TestGraphMinMaxLength {
    public static void main(String[] args) {
        TestGraphMinMaxLength test = new TestGraphMinMaxLength();
    }

    TestGraphMinMaxLength() {
        //whenEgeGraph();
//        whenOneElementInMatrix();
        check();
    }

    private void whenEgeGraph() {
        int[][] arr = new int[][]   { {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0} };

        int[][] arr1 = new int[][]   { {0, 1, 0},
                {1, 0, 0},
                {0, 0, 0} };

        Graph graph = new Graph(arr1);
        graph.print();
        //System.out.println(graph.findMinLength(0, 5));
        //System.out.println(graph.countPath(0, 5));
        System.out.println(graph.findMinLength(0, 2));
        System.out.println(graph.findMinLength(2, 0));
        //System.out.println(graph.findMaxLength(0, 6));
        //if (graph.findMinLength(0, 5) == 2) {
        //    System.out.println("ege graph min length checked");
        //}
        //if (graph.findMaxLength(0, 5) == 6) {
        //    System.out.println("ege graph max length checked");
        //}
        //if (graph.findMinLength(0, 6) == 2) {
        //    System.out.println("ege graph min length checked");
        //}
        //if (graph.findMaxLength(0, 6) == 5) {
        //    System.out.println("ege graph max length checked");
        //}
    }

    private void whenOneElementInMatrix() {
        int[][] arr = new int[1][1];
        arr[0][0] = 1;
        Graph graph = new Graph(arr);

        System.out.println(graph.findMinLength(0, 0));
        System.out.println(graph.findMaxLength(0, 0));
        if (graph.findMinLength(0, 0) == 0) {
            System.out.println("ege graph min length checked");
        }
        if (graph.findMinLength(0, 0) == 0) {
            System.out.println("ege graph max length checked");
        }
    }

    private void check() {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[][]   { {0, 0, 0, 0, 0, 0, 0},
                                      {0, 0, 1, 0, 1, 0, 0},
                                      {0, 1, 0, 1, 0, 0, 0},
                                      {0, 0, 1, 0, 1, 1, 0},
                                      {0, 1, 0, 1, 0, 1, 0},
                                      {0, 0, 0, 1, 1, 0, 0},
                                      {0, 0, 0, 0, 0, 0, 0} };

        Graph graph = new Graph(arr);
        graph.print();
        System.out.println("count: " + graph.countСycle());

        int[][] arr1 = new int[][] { {0, 1},
                                    {1, 0}};
        Graph graph1 = new Graph(arr1);
        graph1.print();
        System.out.println("count: " + graph1.countСycle());

        int[][] arr2 = new int[][]    { {0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 1, 0, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 1, 0},
                                        {0, 1, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 0, 1, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0} };

        Graph graph2 = new Graph(arr2);
        graph2.print();
        System.out.println("count: " + graph2.countСycle());
        System.out.println("count: " + graph2.countСycle());


    }
}