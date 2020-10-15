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

        int[][] arr2 = new int[][]   {
                {0, 0, 0, 0, 0, 0, 0},//, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},//, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},//, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1, 1},//, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},//, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 1},//, 0, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0}};//, 0, 0, 1, 1},
                //{0, 0, 0, 1, 0, 0, 0, 0, 1, 0 ,0},
                //{0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0},
                //{0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                //{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}};

        int[][] arr1 = new int[][]   { {0, 1, 0},
                {1, 0, 0},
                {0, 0, 0} };

        Graph graph = new Graph(arr2);
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
        int[][] arr2 = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0 ,0},
                {0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}};

        int[][] arr82 = new int[][] {
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0 ,0},
                {0, 0, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0}};
        int[][] arr3 = new int[][]
       {{ 0,0,1,0,0,0,0,0,0,0},
        { 1,0,0,0,1,0,0,0,0,0 },
        { 0,1,0,0,0,1,0,0,0,0 },
        { 0,1,0,0,0,0,0,1,0,0 },
        { 0,0,1,1,0,0,0,0,1,0 },
        { 0,0,0,0,1,0,0,0,0,1 },
        { 0,0,0,1,0,0,0,0,0,0 },
        { 0,0,0,0,1,0,1,0,0,0 },
        { 0,0,0,0,0,1,0,1,0,0 },
        { 0,0,0,0,0,0,0,0,1,0 }
                };

        int[][] arr4 = new int[][]  {
                { 0, 1, 1, 0, 0, 0},
                { 1, 0, 1, 1, 1, 0},
                { 1, 1, 0, 0, 1, 1},
                { 0, 1, 0, 0, 1, 0},
                { 0, 1, 1, 1, 0, 1},
                { 0, 0, 1, 0, 1, 0}
        };

        Graph graph = new Graph(arr82);
        graph.print();
        System.out.println("count: " + graph.countСycle());

    }
}